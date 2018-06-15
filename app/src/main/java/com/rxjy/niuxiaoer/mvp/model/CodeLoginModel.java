package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.CodeLoginContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/27.
 */

public class CodeLoginModel implements CodeLoginContract.Model {
    @Override
    public Observable<String> getTokenByCode(String userNo, String vCode) {
        return ApiEngine.getInstance().getRsApiService()
                .getTokenByCode(userNo, vCode,142)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getLoginUserInfoByCode(String userNo, String token) {
        return ApiEngine.getInstance().getRsApiService()
                .getLoginUserInfo(userNo, token)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getVCode(String phoneNum) {
        return ApiEngine.getInstance().getRsApiService()
                .getVCodeLogin(phoneNum)
                .compose(RxSchedulers.<String>switchThread());
    }
}
