package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.MainContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/8/17.
 */

public class MainModel implements MainContract.Model {
    @Override
    public Observable<String> getTabState(String card) {
        return ApiEngine.getInstance().getSwApiService()
                .getTabState(card)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getMineState(String card) {
        return ApiEngine.getInstance().getSwApiService()
                .getMineState(card)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getNewDanHao(String Card) {
        return ApiEngine.getInstance().getSwApiService()
                .getNewDanHao(Card)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getNewZiDuanPrice() {
        return ApiEngine.getInstance().getSwApiService()
                .getNewZiDuanPrice()
                .compose(RxSchedulers.<String>switchThread());
    }
}
