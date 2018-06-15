package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.ProjectDahuiContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ProjectDahuiModel implements ProjectDahuiContract.Model {
    @Override
    public Observable<String> getProjectDahui(String DanHao) {
        return ApiEngine.getInstance().getSwApiService()
                .getProjectDahuiInfo(DanHao)
                .compose(RxSchedulers.<String>switchThread());
    }
}
