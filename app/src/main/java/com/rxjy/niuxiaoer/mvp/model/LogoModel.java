package com.rxjy.niuxiaoer.mvp.model;



import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.LogoContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/1.
 */

public class LogoModel implements LogoContract.Model {
    @Override
    public Observable<String> getLoginUserInfo(String userNo, String token) {
        return ApiEngine.getInstance().getRsApiService()
                .getLoginUserInfo(userNo, token)
                .compose(RxSchedulers.<String>switchThread());
    }
}
