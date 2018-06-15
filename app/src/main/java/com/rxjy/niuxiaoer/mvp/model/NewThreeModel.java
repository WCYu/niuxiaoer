package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.NewThreeContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public class NewThreeModel implements NewThreeContract.Model {
    @Override
    public Observable<String> getxunjia(String DanHao) {
        return ApiEngine.getInstance().getSwApiService()
                .getxunjiaFangyuan(DanHao)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> upxunjia(String DanHao, double MianJi, int ChengJiaoLeiXing, int MianZuQi, String JiaoFangShiJian, int YuJiZhuangXiu, double PingGuPrice, int FangYuan) {
        return ApiEngine.getInstance().getSwApiService()
                .upxunjiaFangyuan(DanHao,MianJi,ChengJiaoLeiXing,MianZuQi,JiaoFangShiJian,YuJiZhuangXiu,PingGuPrice,FangYuan)
                .compose(RxSchedulers.<String>switchThread());
    }


}
