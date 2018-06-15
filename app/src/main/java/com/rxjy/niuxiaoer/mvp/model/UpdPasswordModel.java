package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.UpdPasswordContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/27.
 */

public class UpdPasswordModel implements UpdPasswordContract.Model {
    @Override
    public Observable<String> updatePwd(String cardNo, String password, String newPassword, String token) {
        return ApiEngine.getInstance().getRsApiService()
                .updatePassword(cardNo, password, newPassword, token)
                .compose(RxSchedulers.<String>switchThread());
    }
}
