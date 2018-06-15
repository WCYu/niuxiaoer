package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.SubmitDialogContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public class SubmitDialogModel implements SubmitDialogContract.Model {
    @Override
    public Observable<String> getName(String DanHao) {
        return ApiEngine.getInstance().getSwApiService()
                .getKehuxingming(DanHao)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> UpBaoCunOrSubmit(String DanHao, String Phone, String XingMing, int SubmitType) {
        return ApiEngine.getInstance().getSwApiService()
                .UpBaoCunOrSubmit(DanHao,Phone,XingMing,SubmitType)
                .compose(RxSchedulers.<String>switchThread());
    }
}
