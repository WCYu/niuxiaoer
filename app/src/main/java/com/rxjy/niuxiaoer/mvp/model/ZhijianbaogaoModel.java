package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.ZhijianbaogaoContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ZhijianbaogaoModel implements ZhijianbaogaoContract.Model {
    @Override
    public Observable<String> getProjectDahui(String DanHao) {
        return ApiEngine.getInstance().getSwApiService()
                .getZhijianbaogaoInfo(DanHao)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getZhijianhegeInfo(String DanHao, int Type) {
        return ApiEngine.getInstance().getSwApiService()
                .getZhijianhegeInfo(DanHao,Type)
                .compose(RxSchedulers.<String>switchThread());
    }
}
