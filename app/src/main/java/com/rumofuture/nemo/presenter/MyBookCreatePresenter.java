package com.rumofuture.nemo.presenter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.rumofuture.nemo.R;
import com.rumofuture.nemo.app.NemoCallback;
import com.rumofuture.nemo.app.contract.MyBookCreateContract;
import com.rumofuture.nemo.app.manager.ImageChooseManager;
import com.rumofuture.nemo.model.entity.Book;
import com.rumofuture.nemo.model.entity.User;
import com.rumofuture.nemo.model.schema.UserSchema;
import com.rumofuture.nemo.model.source.BookDataSource;
import com.rumofuture.nemo.model.source.UserDataSource;
import com.rumofuture.nemo.view.fragment.MyBookCreateFragment;
import com.smile.filechoose.api.ChosenImage;

import java.io.File;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by WangZhenqi on 2017/4/13.
 */

public class MyBookCreatePresenter implements MyBookCreateContract.Presenter {

    private MyBookCreateContract.View mView;
    private UserDataSource mUserRepository;
    private BookDataSource mBookRepository;
    private ImageChooseManager mImageChooseManager;
    private ChosenImage mCoverImage;

    public MyBookCreatePresenter(
            @NonNull MyBookCreateContract.View view,
            @NonNull UserDataSource userRepository,
            @NonNull BookDataSource bookRepository
    ) {
        mView = view;
        mUserRepository = userRepository;
        mBookRepository = bookRepository;
        start();
    }

    @Override
    public void start() {
        mImageChooseManager = new ImageChooseManager((MyBookCreateFragment) mView, this);  // 构造成功默认创建一个图片选择器
    }

    /**
     * 图片选择方法，view发出图片选择请求时将调用此方法
     */
    @Override
    public void chooseImage() {
        start();
        // 获取选择到的图片
        mImageChooseManager.chooseImage(((MyBookCreateFragment) mView).getActivity());
    }

    @Override
    public void submitChoice(int requestCode, Intent data) {
        // 图片选择的中间操作
        mImageChooseManager.submitChoice(requestCode, data);
    }

    @Override
    public void createBook(final Book book) {

        // 如果未选择封面，则取消创建并提示错误
        if (mCoverImage == null) {
            if (mView.isActive()) {
                mView.showBookInfoError(R.string.prompt_book_cover_required);
            }
            return;
        }

        // 如果未填写漫画册名称，则取消创建并提示错误
        if (TextUtils.isEmpty(book.getName())) {
            if (mView.isActive()) {
                mView.showBookInfoError(R.string.prompt_book_name_required);
            }
            return;
        }

        // 如果未填写漫画册风格，则取消创建并提示错误
        if (TextUtils.isEmpty(book.getStyle())) {
            if (mView.isActive()) {
                mView.showBookInfoError(R.string.prompt_book_style_required);
            }
            return;
        }

        // 如果未填写漫画册简介，则取消创建并提示错误
        if (TextUtils.isEmpty(book.getIntroduction())) {
            if (mView.isActive()) {
                mView.showBookInfoError(R.string.prompt_book_introduction_required);
            }
            return;
        }

        mView.showProgressBar(true);
        // 显示进度条
        book.setCover(new BmobFile(new File(mCoverImage.getFilePathOriginal())));
        book.setAuthor(BmobUser.getCurrentUser(User.class));
        book.setPage(0);
        book.setFavor(0);
        book.setStatus(1);
        mBookRepository.saveBook(book, new NemoCallback<Book>() {
            @Override
            public void onSuccess(Book data) {
                if (mView.isActive()) {
                    mView.showBookCreateSuccess(book);
                    mView.showProgressBar(false);
                }

                User currentUser = BmobUser.getCurrentUser(User.class);
                currentUser.increment(UserSchema.Table.Cols.BOOK);
                mUserRepository.updateUserInfo(currentUser, new NemoCallback<User>() {
                    @Override
                    public void onSuccess(User data) {

                    }

                    @Override
                    public void onFailed(String message) {

                    }
                });
            }

            @Override
            public void onFailed(String message) {
                if (mView.isActive()) {
                    mView.showBookCreateFailed(message);
                    mView.showProgressBar(false);
                }
            }
        });
    }

    @Override
    public void setChosenImage(ChosenImage chosenImage) {
        mCoverImage = chosenImage;
        ((MyBookCreateFragment) mView).getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mView.isActive()) {
                    mView.showBookCoverHasChosen(mCoverImage.getFilePathOriginal());
                }
            }
        });
    }

    @Override
    public void releaseImageChooseManager() {

    }
}
