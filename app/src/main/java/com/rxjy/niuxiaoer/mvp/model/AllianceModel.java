package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.AllianceContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/17.
 */

public class AllianceModel implements AllianceContract.Model {
    @Override
    public Observable<String> getAllianceList(String cardNo) {
        return ApiEngine.getInstance().getSwApiService()
                .getAllyList(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> joinUnion(String cardNo, String superiorCard) {
        return ApiEngine.getInstance().getSwApiService()
                .joinUnion(cardNo, superiorCard)
                .compose(RxSchedulers.<String>switchThread());
    }
}
