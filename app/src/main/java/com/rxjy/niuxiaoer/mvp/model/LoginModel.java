package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.LoginContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/27.
 */

public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<String> getToken(String userNo, String password) {
        return ApiEngine.getInstance().getRsApiService()
                .getToken(userNo, password, 142)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getLoginUserInfo(String userNo, String token) {
        return ApiEngine.getInstance().getRsApiService()
                .getLoginUserInfo(userNo, token)
                .compose(RxSchedulers.<String>switchThread());
    }
}
