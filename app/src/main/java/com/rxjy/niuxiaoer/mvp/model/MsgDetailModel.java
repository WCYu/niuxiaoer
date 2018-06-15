package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.MsgDetailContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/9/19.
 */

public class MsgDetailModel implements MsgDetailContract.Model {
    @Override
    public Observable<String> getMsgDetail(int xinID) {
        return ApiEngine.getInstance().getSwApiService()
                .getMsgDetail(xinID)
                .compose(RxSchedulers.<String>switchThread());
    }
}
