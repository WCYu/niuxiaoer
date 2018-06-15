package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.RegisterContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/27.
 */

public class RegisterModel implements RegisterContract.Model {

    @Override
    public Observable<String> getRegister(String code, String phoneNum, String password, String invitationCode) {
        return ApiEngine.getInstance().getRsApiService()
                .getRegister(code, phoneNum, password, 2, "牛小二", 142, invitationCode)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getVerificationCode(String phoneNum) {
        return ApiEngine.getInstance().getSwApiService()
                .getVerificationCode(phoneNum)
                .compose(RxSchedulers.<String>switchThread());
    }

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

    @Override
    public Observable<String> getYaoQingMa(String card) {
        return ApiEngine.getInstance().getSwApiService()
                .getYaoQingMa(card)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getMemberInfo(String card, String phone, String shcard) {
        return ApiEngine.getInstance().getSwApiService()
                .getMemberInfo(card,phone,shcard)
                .compose(RxSchedulers.<String>switchThread());
    }
}
