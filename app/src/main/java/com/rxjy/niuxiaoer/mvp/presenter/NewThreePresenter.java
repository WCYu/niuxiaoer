package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.NewThreeInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.NewThreeContract;
import com.rxjy.niuxiaoer.mvp.model.NewThreeModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/13.
 */

public class NewThreePresenter extends NewThreeContract.Presenter{

    public static final String TAG = "NewThreePresenter";

    public NewThreePresenter(NewThreeContract.View mView) {
        this.mView = mView;
        mModel = new NewThreeModel();
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
                        Log.e(TAG, "获取ThreeData失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取ThreeData成功 = " + s);
                        NewThreeInfo info=JSONUtils.toObject(s, NewThreeInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetData(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void upxunjia(String DanHao, double MianJi, int ChengJiaoLeiXing, int MianZuQi, String JiaoFangShiJian, int YuJiZhuangXiu, double PingGuPrice, int FangYuan) {
        Subscription subscribe = mModel.upxunjia(DanHao,MianJi,ChengJiaoLeiXing,MianZuQi,JiaoFangShiJian,YuJiZhuangXiu, PingGuPrice,FangYuan)
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
                        Log.e(TAG, "上传ThreeData失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传ThreeData成功 = " + s);
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
}
