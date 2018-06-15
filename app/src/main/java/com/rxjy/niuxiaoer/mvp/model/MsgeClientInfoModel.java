package com.rxjy.niuxiaoer.mvp.model;


import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.MsgeClientInfoContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/30.
 */
public class MsgeClientInfoModel implements MsgeClientInfoContract.Model {
    @Override
    public Observable<String> getTc() {
        return ApiEngine.getInstance().getSwApiService()
                .getTc("1")
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getClientType() {
        return ApiEngine.getInstance().getSwApiService()
                .getClientType()
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getOrdersDetail(int customerID) {
        return ApiEngine.getInstance().getSwApiService()
                .getMsgeOrdersDetail(customerID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> saveOrdersDetail(
            int customID,
            String XingMing,
            String ShouJiHaoYi,
            String MianJi,
            String LeiXingYi,
            String LeiXingEr,
            String GongSiMingCheng,
            String LiangFangDiZhi,
            String KaHao,
            String FangYuan,
            String BeiZhu,
            String Package_type,
            String ZhuangTai,
            int FenGongSiID) {
        return ApiEngine.getInstance().getSwApiService()
                .saveOrdersDetail(customID, XingMing, ShouJiHaoYi, MianJi, LeiXingYi, LeiXingEr, GongSiMingCheng, LiangFangDiZhi, KaHao, FangYuan, BeiZhu, Package_type, ZhuangTai,FenGongSiID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> subOrdersDetail(int customerID, String cardNo, int type, int state, int filialeID, String clientName, String phoneNum, String companyName, double priceUnit, double acreage, String businessAddress, String measureAddress, int ornamentTime, int timeProject, String startTime, String endTime, String measureTime, int clientDemandOne, int clientDemandTwo, int resourceState, int houseState, int administration, int desDemand, int transactionType, int limeLight) {
        return ApiEngine.getInstance().getSwApiService()
                .subOrdersDetail(customerID, cardNo, type, state, filialeID, clientName, phoneNum, companyName, priceUnit, acreage, businessAddress, measureAddress, ornamentTime, timeProject, startTime, endTime, measureTime, clientDemandOne, clientDemandTwo, resourceState, houseState, administration, desDemand, transactionType, limeLight)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getFenGongSi() {
        return ApiEngine.getInstance().getSwApiService()
                .getFenGongSi()
                .compose(RxSchedulers.<String>switchThread());
    }
}
