package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.AddBankCardContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/7/28.
 */

public class AddBankCardModel implements AddBankCardContract.Model {
    @Override
    public Observable<String> subAddBankCard(String token, String cardNo, String bankCard, String bankName, String bankUserName) {
        return ApiEngine.getInstance().getRsApiService()
                .subAddOrUpd(token, cardNo, bankCard, bankName, bankUserName)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getBankListInfo() {
        return ApiEngine.getInstance().getRsApiService()
                .getBankListInfo()
                .compose(RxSchedulers.<String>switchThread());
    }
}
