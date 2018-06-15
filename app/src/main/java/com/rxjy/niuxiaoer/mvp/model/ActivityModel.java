package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.ActivityContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/9/18.
 */

public class ActivityModel implements ActivityContract.Model {
    @Override
    public Observable<String> getActivityList() {
        return ApiEngine.getInstance().getSwApiService()
                .getActivityList()
                .compose(RxSchedulers.<String>switchThread());
    }
}
