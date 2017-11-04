package com.rumofuture.nemo.presenter;

import android.support.annotation.NonNull;

import com.rumofuture.nemo.model.entity.User;
import com.rumofuture.nemo.model.source.UserDataSource;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;

public class NemoMainMePresenter implements UserDataSource.UserInfoUpdateCallback {

    private UserDataSource mUserRepository;

    public NemoMainMePresenter(
            @NonNull UserDataSource userRepository
    ) {
        mUserRepository = userRepository;
    }


    public void start() {

    }

    public void getAuthorization() {
        User user = BmobUser.getCurrentUser(User.class);
        user.setAuthorize(true);
        mUserRepository.updateUserInfo(user, this);
    }

    @Override
    public void onUserInfoUpdateSuccess() {

    }

    @Override
    public void onUserInfoUpdateFailed(BmobException e) {
        BmobUser.getCurrentUser(User.class).setAuthorize(false);
    }
}
