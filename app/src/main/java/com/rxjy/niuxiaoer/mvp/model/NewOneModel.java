package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.NewOneContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/12.
 */

public class NewOneModel implements NewOneContract.Model {

    @Override
    public Observable<String> getjiben(String DanHao) {
        return ApiEngine.getInstance().getSwApiService()
                .getjiben(DanHao)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getjibenXialakuang() {
        return ApiEngine.getInstance().getSwApiService()
                .getjibenXialakuang()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> upjiben(String DanHao, String GongSiMingCheng, String BanGongDiDian, int LeiXingYi, double PingGuPrice, String Phone, String XingMing, String SparePhone) {
        return ApiEngine.getInstance().getSwApiService()
                .upjibenNew(DanHao,GongSiMingCheng,BanGongDiDian,LeiXingYi,PingGuPrice,Phone,XingMing,SparePhone)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getphone(String phoneNum) {
        return ApiEngine.getInstance().getSwApiService()
                .postCustomerPhone(phoneNum)
                .compose(RxSchedulers.<String>switchThread());
    }

//    @Override
//    public Observable<String> upjiben(String DanHao, String GongSiMingCheng, String BanGongDiDian, int LeiXingYi, double PingGuPrice) {
//        return ApiEngine.getInstance().getSwApiService()
//                .upjiben(DanHao,GongSiMingCheng,BanGongDiDian,LeiXingYi,PingGuPrice)
//                .compose(RxSchedulers.<String>switchThread());
//    }
}
