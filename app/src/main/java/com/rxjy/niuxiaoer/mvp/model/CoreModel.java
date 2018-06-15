package com.rxjy.niuxiaoer.mvp.model;


import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.CoreContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/15.
 */
public class CoreModel implements CoreContract.Model {

    @Override
    public Observable<String> getIP() {
        return ApiEngine.getInstance().getRsApiService()
                .getIP("https://icanhazip.com")
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subAppInfo(String cardNo, String province, String city, String equipment, String ip, String netWorkStatus) {
        return ApiEngine.getInstance().getRsApiService()
                .subAppInfo(cardNo, province, city, equipment, ip, netWorkStatus)
                .compose(RxSchedulers.<String>switchThread());
    }
}
