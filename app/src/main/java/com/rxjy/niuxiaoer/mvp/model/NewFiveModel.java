package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.NewFiveContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public class NewFiveModel implements NewFiveContract.Model {
    @Override
    public Observable<String> getxunjia(String DanHao) {
        return ApiEngine.getInstance().getSwApiService()
                .getxunjiaLoupan(DanHao)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> upxunjia(String DanHao, int QiYeGuiMoID, String BuildName, String LouPanQiZuo, double PingGuPrice,int SubmitType) {
        return ApiEngine.getInstance().getSwApiService()
                .upxunjiaLoupan(DanHao,QiYeGuiMoID,BuildName,LouPanQiZuo,PingGuPrice,SubmitType)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> UpBaoCunOrSubmit(String DanHao, String Phone, String XingMing, int SubmitType) {
        return ApiEngine.getInstance().getSwApiService()
                .UpBaoCunOrSubmit(DanHao,Phone,XingMing,SubmitType)
                .compose(RxSchedulers.<String>switchThread());
    }
}
