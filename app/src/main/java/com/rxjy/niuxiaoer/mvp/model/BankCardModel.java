package com.rxjy.niuxiaoer.mvp.model;


import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.BankCardContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/23.
 */

public class BankCardModel implements BankCardContract.Model {
    @Override
    public Observable<String> getLoginUserInfo(String userNo, String token) {
        return ApiEngine.getInstance().getRsApiService()
                .getLoginUserInfo(userNo, token)
                .compose(RxSchedulers.<String>switchThread());
    }
}
