package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.NewFiveInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.NewFiveContract;
import com.rxjy.niuxiaoer.mvp.model.NewFiveModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/13.
 */

public class NewFivePresenter extends NewFiveContract.Presenter {

    public static final String TAG = "NewFivePresenter";

    public NewFivePresenter(NewFiveContract.View mView) {
        this.mView = mView;
        mModel = new NewFiveModel();
    }

    @Override
    public void getxunjia(String DanHao) {
        Subscription subscribe = mModel.getxunjia(DanHao)
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
                        Log.e(TAG, "获取FiveData失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取FiveData成功 = " + s);
                        NewFiveInfo info= JSONUtils.toObject(s, NewFiveInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetData(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void upxunjia(String DanHao, int QiYeGuiMoID, String BuildName, String LouPanQiZuo, double PingGuPrice ,int SubmitType) {
        Subscription subscribe = mModel.upxunjia(DanHao,QiYeGuiMoID,BuildName,LouPanQiZuo,PingGuPrice,SubmitType)
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
                        Log.e(TAG, "上传FiveData失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传FiveData成功 = " + s);
                        UpPartAddInfo info=JSONUtils.toObject(s, UpPartAddInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseUpData(info);
                        }else{
                            mView.responseUpDataError("上传失败");
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void UpBaoCunOrSubmit(String DanHao, String Phone, String XingMing, int SubmitType) {

        Subscription subscribe = mModel.UpBaoCunOrSubmit(DanHao,Phone,XingMing,SubmitType)
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
                        Log.e(TAG, "上传信息失败 = " + e.toString());
                        mView.responseUpXinxiError("上传失败");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传信息成功 = " + s);
                        UpPartAddInfo info= JSONUtils.toObject(s, UpPartAddInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseUpXinxi(info);
                        }else {
                            mView.responseUpXinxiError("上传失败");
                        }
                    }
                });
        addSubscribe(subscribe);

    }

}
