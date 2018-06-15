package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.ForgetPwdContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/27.
 */

public class ForgetPwdModel implements ForgetPwdContract.Model {
    @Override
    public Observable<String> updatePassword(String phoneNum, String newPassword, String vCode) {
        return ApiEngine.getInstance().getRsApiService()
                .updatePasswordByForget(phoneNum, newPassword, vCode)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getVCode(String phoneNum) {
        return ApiEngine.getInstance().getRsApiService()
                .getVCodeForgetPassword(phoneNum)
                .compose(RxSchedulers.<String>switchThread());
    }
}
