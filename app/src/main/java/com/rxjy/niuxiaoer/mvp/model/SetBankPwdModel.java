package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.SetBankPwdContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/1.
 */

public class SetBankPwdModel implements SetBankPwdContract.Model {

    @Override
    public Observable<String> getSetPwd(String cardNo, String pwd) {
        return ApiEngine.getInstance().getSwApiService()
                .setBankCardPwd(cardNo, pwd)
                .compose(RxSchedulers.<String>switchThread());
    }
}
