package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.NewFourContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public class NewFourModel implements NewFourContract.Model {
    @Override
    public Observable<String> getxunjia(String DanHao) {
        return ApiEngine.getInstance().getSwApiService()
                .getxunjiaXuqiu(DanHao)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> upxunjia(String DanHao, String LiangFangDiZhi, int ZhuangXiuXuQiu, String YuJiLiangFang, String GongQi, double ZhuangXiuYuSuan, double PingGuPrice, int ZhaoBiao, String YuJiZhuangXiuShiJian) {
        return ApiEngine.getInstance().getSwApiService()
                .upxunjiaXuqiu(DanHao,LiangFangDiZhi,ZhuangXiuXuQiu,YuJiLiangFang,GongQi,ZhuangXiuYuSuan,PingGuPrice,ZhaoBiao,YuJiZhuangXiuShiJian)
                .compose(RxSchedulers.<String>switchThread());
    }
}
