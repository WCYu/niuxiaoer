package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.ProjectInfoContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ProjectInfoModel implements ProjectInfoContract.Model {
    @Override
    public Observable<String> getProjectInfo(String DanHao) {
        return ApiEngine.getInstance().getSwApiService()
                .getProjectInfo(DanHao)
                .compose(RxSchedulers.<String>switchThread());
    }
}
