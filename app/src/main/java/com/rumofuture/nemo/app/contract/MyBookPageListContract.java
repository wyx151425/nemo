package com.rumofuture.nemo.app.contract;

import com.rumofuture.nemo.app.NemoView;
import com.rumofuture.nemo.model.entity.Book;
import com.rumofuture.nemo.model.entity.Page;
import com.rumofuture.nemo.presenter.NemoImageUploadPresenter;

import java.util.List;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by WangZhenqi on 2017/4/15.
 */

public interface MyBookPageListContract {

    interface View extends NemoView<MyBookPageListContract.Presenter> {
        void showProgressBar(boolean show, int stringId);

        void showPageSaveSuccess(Page page);
        void showPageSaveFailed(String message);

        void showPageDeleteSuccess(Page page);
        void showPageDeleteFailed(String message);

        void showPageUpdateSuccess(Page page);
        void showPageUpdateFailed(String message);

        void showPageListGetSuccess(List<Page> pageList);
        void showPageListGetFailed(String message);

        boolean isActive();
    }

    interface Presenter extends NemoImageUploadPresenter {
        void uploadPage(Page page);
        void deletePage(Page page);
        void updatePage(Page page);
        void getBookPageList(Book book, int pageCode);
    }
}
