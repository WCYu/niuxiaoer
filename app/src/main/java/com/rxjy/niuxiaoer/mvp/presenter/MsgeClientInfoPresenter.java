package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;


import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.FenGongSiInfo;
import com.rxjy.niuxiaoer.entity.GetClientDetailInfo;
import com.rxjy.niuxiaoer.entity.GetClientDetailInfo_List;
import com.rxjy.niuxiaoer.entity.MsgeClientTypeInfo;
import com.rxjy.niuxiaoer.entity.TcInfo;
import com.rxjy.niuxiaoer.mvp.contract.MsgeClientInfoContract;
import com.rxjy.niuxiaoer.mvp.model.MsgeClientInfoModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/6/30.
 */
public class MsgeClientInfoPresenter extends MsgeClientInfoContract.Presenter {

    public static final String TAG = "MsgeClientInfoPresenter";

    public MsgeClientInfoPresenter(MsgeClientInfoContract.View mView) {
        this.mView = mView;
        mModel = new MsgeClientInfoModel();
    }

    @Override
    public void getClientType() {
        Subscription subscribe = mModel.getClientType()
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {

                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取客户类型失败" + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取客户类型成功" + s.toString());
                        MsgeClientTypeInfo info = JSONUtils.toObject(s, MsgeClientTypeInfo.class);
                        if (info.getStatusCode() == 0) {
                            MsgeClientTypeInfo.ClientType data = info.getBody();
                            mView.responseClientTypeData(data);
                        } else {
                            mView.responseClientTypeDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }


    @Override
    public void getTc() {
        Subscription subscribe = mModel.getTc()
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取套餐类型信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取套餐类型信息成功 = " + s.toString());
                        TcInfo info = JSONUtils.toObject(s, TcInfo.class);
                        if (info.getStatusCode() == 0 && !info.getBody().toString().isEmpty()) {
                            TcInfo.BodyBean data = info.getBody();
                            List<TcInfo.BodyBean.TC> tcList = data.getPackageType();
                            List<TcInfo.BodyBean.ClientType> clientList = data.getCusTomer();
                            mView.responseTc(tcList);
                            mView.responseClientType(clientList);
                        } else {
                            mView.responseTcError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }


    @Override
    public void getOrdersDetail(int customerID) {
        Subscription subscribe = mModel.getOrdersDetail(customerID)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取客户信息详情失败" + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取客户信息详情成功" + s.toString());
                        GetClientDetailInfo info = JSONUtils.toObject(s, GetClientDetailInfo.class);
                        if (info.getStatusCode() == 0) {
                            GetClientDetailInfo.BodyBean data = info.getBody();
                            mView.responseOrdersDetailData(data);
                        } else {
                            mView.responseOrdersDetailDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void saveOrdersDetail(
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
        Subscription subscribe = mModel.saveOrdersDetail(customID, XingMing, ShouJiHaoYi, MianJi, LeiXingYi, LeiXingEr, GongSiMingCheng, LiangFangDiZhi, KaHao, FangYuan, BeiZhu, Package_type, ZhuangTai,FenGongSiID)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog2();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "修改客户信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "修改客户信息成功 = " + s.toString());
                        GetClientDetailInfo_List info = JSONUtils.toObject(s, GetClientDetailInfo_List.class);
                        if (info.getStatusCode() == 0) {
                            Log.e("MsgeClient",info.getStatusCode()+"");
                            mView.responseSaveClientInfoData();
                        } else {
                            mView.responseSaveClientInfoDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void subOrdersDetail(int customerID, String cardNo, int type, int state, int filialeID, String clientName, String phoneNum, final String companyName, double priceUnit, double acreage, String businessAddress, String measureAddress, int ornamentTime, int timeProject, String startTime, String endTime, String measureTime, int clientDemandOne, int clientDemandTwo, int resourceState, int houseState, int administration, int desDemand, int transactionType, int limeLight) {
        Subscription subscribe = mModel.subOrdersDetail(customerID, cardNo, type, state, filialeID, clientName, phoneNum, companyName, priceUnit, acreage, businessAddress, measureAddress, ornamentTime, timeProject, startTime, endTime, measureTime, clientDemandOne, clientDemandTwo, resourceState, houseState, administration, desDemand, transactionType, limeLight)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "添加客户信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        GetClientDetailInfo info = JSONUtils.toObject(s, GetClientDetailInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseSubClientInfoData();
                        } else {
                            mView.responseSubClientInfoDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getFenGongSi() {
        Subscription subscribe=mModel.getFenGongSi()
                .subscribe(new Subscriber<String>()
                {
                    @Override
                    public void onStart()
                    {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted()
                    {
                        mView.hideDialog();

                    }

                    @Override
                    public void onError(Throwable e)
                    {

                        Log.e(TAG,"获取分公司信息失败 = " + e.toString());
                        mView.hideDialog();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取分公司信息结果" + s);
                        FenGongSiInfo info=JSONUtils.toObject(s, FenGongSiInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseFenGongSi(info.getBody());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
