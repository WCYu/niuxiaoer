package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.AddContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/28.
 */
public class AddModel implements AddContract.Model
{
    @Override
    public Observable<String> getTc() {
        return ApiEngine.getInstance().getSwApiService()
                .getTc("1")
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> addandsubmit(String XingMing, String ShouJiHaoYi, String MianJi, String LeiXingYi, String LeiXingEr, String GongSiMingCheng, String LiangFangDiZhi, String KaHao, String FangYuan, String BeiZhu, String Package_type, String ZhuangTai,int FenGongSiID)
    {
        return ApiEngine.getInstance().getSwApiService()
                .UpAndSubmit(XingMing,ShouJiHaoYi,MianJi,LeiXingYi,LeiXingEr,GongSiMingCheng,LiangFangDiZhi,KaHao,FangYuan,BeiZhu,Package_type,ZhuangTai,FenGongSiID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getFenGongSi() {
        return ApiEngine.getInstance().getSwApiService()
                .getFenGongSi()
                .compose(RxSchedulers.<String>switchThread());
    }
}
