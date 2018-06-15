package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;


import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.UserInfo;
import com.rxjy.niuxiaoer.mvp.contract.LogoContract;
import com.rxjy.niuxiaoer.mvp.model.LogoModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/1.
 */

public class LogoPresenter extends LogoContract.Presenter {

    public static final String TAG = "LogoPresenter";

    public LogoPresenter(LogoContract.View mView) {
        this.mView = mView;
        mModel = new LogoModel();
    }

    @Override
    public void getLoginUserInfo(String userNo, String token) {
        Subscription subscribe = mModel.getLoginUserInfo(userNo, token)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取用户信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        UserInfo info = JSONUtils.toObject(s, UserInfo.class);
                        if (info.getStatusCode() == 0) {
                            UserInfo.User data = info.getBody();
                            mView.responseLogin(data);
                        } else if (info.getStatusCode() == 104) {
                            mView.reLogin(info.getStatusMsg());
                        } else {
                            mView.responseLoginError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
