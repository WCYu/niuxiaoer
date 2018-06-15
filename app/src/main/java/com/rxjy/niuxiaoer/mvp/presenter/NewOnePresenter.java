package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.NewOneInfo;
import com.rxjy.niuxiaoer.entity.NewOneXiaLaInfo;
import com.rxjy.niuxiaoer.entity.StatusBean;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfoNew;
import com.rxjy.niuxiaoer.mvp.contract.NewOneContract;
import com.rxjy.niuxiaoer.mvp.model.NewOneModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/12.
 */

public class NewOnePresenter extends NewOneContract.Presenter{

    public static final String TAG = "NewOnePresenter";

    public NewOnePresenter(NewOneContract.View mView) {
        this.mView = mView;
        mModel = new NewOneModel();
    }

    @Override
    public void getjiben(String DanHao) {
        Subscription subscribe = mModel.getjiben(DanHao)
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
                        Log.e(TAG, "获取OneData失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取OneData成功 = " + s);
                        NewOneInfo info=JSONUtils.toObject(s, NewOneInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetData(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getjibenXialakuang() {
        Subscription subscribe = mModel.getjibenXialakuang()
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
                        Log.e(TAG, "获取OneData下拉框失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取OneData下拉框成功 = " + s);
                        NewOneXiaLaInfo info=JSONUtils.toObject(s, NewOneXiaLaInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetXiaLakuangData(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void upjiben(String DanHao, String GongSiMingCheng, String BanGongDiDian, int LeiXingYi, double PingGuPrice, String Phone, String XingMing, String SparePhone) {
        Subscription subscribe = mModel.upjiben(DanHao,GongSiMingCheng,BanGongDiDian,LeiXingYi,PingGuPrice,Phone,XingMing,SparePhone)
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
                        Log.e(TAG, "上传OneData失败 = " + e.toString());
                        mView.responseUpDataError("上传失败");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传OneData成功 = " + s);
                        UpPartAddInfoNew info=JSONUtils.toObject(s, UpPartAddInfoNew.class);
                        if (info.getStatusCode().equals("0")){
                            mView.responseUpData(info);
                        }else{
                            mView.responseUpDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getphone(String phoneNum) {
        Subscription subscribe = mModel.getphone(phoneNum)
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
                        onCompleted();
                        mView.responsephoneError("请检查您的网络！");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("验证客户手机号", s);
                        StatusBean info = JSONUtils.toObject(s, StatusBean.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsephone(s);
                        } else if(info.getStatusCode() == 1){
                            mView.responsephoneError("手机号重复！");
                        }else if(info.getStatusCode() == 3){
                            mView.responsephoneError("验证异常！");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

//    @Override
//    public void upjiben(String DanHao, String GongSiMingCheng, String BanGongDiDian, int LeiXingYi, double PingGuPrice) {
//        Subscription subscribe = mModel.upjiben(DanHao,GongSiMingCheng,BanGongDiDian,LeiXingYi,PingGuPrice)
//                .subscribe(new Subscriber<String>() {
//
//                    @Override
//                    public void onStart() {
//                        mView.showDialog();
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        mView.hideDialog();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "上传OneData失败 = " + e.toString());
//                        mView.responseUpDataError("上传失败");
//                        onCompleted();
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.e(TAG, "上传OneData成功 = " + s);
//                        UpPartAddInfo info=JSONUtils.toObject(s, UpPartAddInfo.class);
//                        if (info.getStatusCode()==0){
//                            mView.responseUpData(info);
//                        }else{
//                            mView.responseUpDataError("上传失败");
//                        }
//                    }
//                });
//        addSubscribe(subscribe);
//    }
}
