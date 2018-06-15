package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.ZhijianYesorNoInfo;
import com.rxjy.niuxiaoer.entity.ZhijianbaogaoInfo;
import com.rxjy.niuxiaoer.mvp.contract.ZhijianbaogaoContract;
import com.rxjy.niuxiaoer.mvp.model.ZhijianbaogaoModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ZhijianbaogaoPresenter extends ZhijianbaogaoContract.Presenter{

    public static final String TAG = "ZhijianbaogaoPresenter";

    public ZhijianbaogaoPresenter(ZhijianbaogaoContract.View mView) {
        this.mView = mView;
        mModel = new ZhijianbaogaoModel();
    }

    @Override
    public void getProjectDahui(String DanHao) {
        Subscription subscribe = mModel.getProjectDahui(DanHao)
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
                        Log.e(TAG, "获取Data失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取Data成功 = " + s);
                        ZhijianbaogaoInfo info= JSONUtils.toObject(s, ZhijianbaogaoInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetData(info.getBody());
                        }

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getZhijianhegeInfo(String DanHao, int Type) {
        Subscription subscribe = mModel.getZhijianhegeInfo(DanHao,Type)
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
                        Log.e(TAG, "获取Data失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取Data成功 = " + s);
                        ZhijianYesorNoInfo info= JSONUtils.toObject(s, ZhijianYesorNoInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responsezhijianYesorNo(info.getBody());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}

