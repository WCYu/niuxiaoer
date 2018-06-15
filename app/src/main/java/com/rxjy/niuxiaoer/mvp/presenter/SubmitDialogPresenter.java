package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.GetKehuXingmingInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.SubmitDialogContract;
import com.rxjy.niuxiaoer.mvp.model.SubmitDialogModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/13.
 */

public class SubmitDialogPresenter extends SubmitDialogContract.Presenter {

    public static final String TAG = "SubmitDialogPresenter";

    public SubmitDialogPresenter(SubmitDialogContract.View mView) {
        this.mView = mView;
        mModel = new SubmitDialogModel();
    }

    @Override
    public void getName(String DanHao) {
        Subscription subscribe = mModel.getName(DanHao)
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
                        Log.e(TAG, "获取姓名失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取姓名成功 = " + s);
                        GetKehuXingmingInfo info= JSONUtils.toObject(s, GetKehuXingmingInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetName(info);
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
                        //mView.responseUpXinxiError("上传失败");
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传信息成功 = " + s);
                        UpPartAddInfo info= JSONUtils.toObject(s, UpPartAddInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseUpXinxi(info);
                        }else {
                            mView.responseUpXinxiError(info);
                        }
                    }
                });
        addSubscribe(subscribe);

    }
}
