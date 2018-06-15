package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.NewTwoContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/12.
 */

public class NewTwoModel implements NewTwoContract.Model {
    @Override
    public Observable<String> getxunjia(String DanHao) {
        return ApiEngine.getInstance().getSwApiService()
                .getxunjia(DanHao)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getxunjiaXialakuang() {
        return ApiEngine.getInstance().getSwApiService()
                .getxunjiaXialakuang()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getxunjiaShenfenXialakuang() {
        return ApiEngine.getInstance().getSwApiService()
                .getxunjiaShenfenXialakuang()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getxunjiaZhuzhongXialakuang() {
        return ApiEngine.getInstance().getSwApiService()
                .getxunjiaZhuzhongXialakuang()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> upxunjia(String DanHao, int ShenFenID, int NianLingID, String XingMing, String WeiXin, int ZhuZhongDianID, double PingGuPrice) {
        return ApiEngine.getInstance().getSwApiService()
                .upxunjia(DanHao,ShenFenID,NianLingID,XingMing,WeiXin,ZhuZhongDianID,PingGuPrice)
                .compose(RxSchedulers.<String>switchThread());
    }
}
