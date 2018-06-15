package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.NewTwoInfo;
import com.rxjy.niuxiaoer.entity.NewTwoXiaLaInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.NewTwoContract;
import com.rxjy.niuxiaoer.mvp.model.NewTwoModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/12.
 */

public class NewTwoPresenter extends NewTwoContract.Presenter {

    public static final String TAG = "NewTwoPresenter";

    public NewTwoPresenter(NewTwoContract.View mView) {
        this.mView = mView;
        mModel = new NewTwoModel();
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
                        Log.e(TAG, "获取TwoData失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取TwoData成功 = " + s);
                        NewTwoInfo info=JSONUtils.toObject(s, NewTwoInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetData(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getxunjiaXialakuang() {
        Subscription subscribe = mModel.getxunjiaXialakuang()
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
                        Log.e(TAG, "获取Two下拉Data失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取Two下拉Data成功 = " + s);
                        NewTwoXiaLaInfo info=JSONUtils.toObject(s, NewTwoXiaLaInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetXiaLakuangData(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getxunjiaShenfenXialakuang() {
        Subscription subscribe = mModel.getxunjiaShenfenXialakuang()
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
                        Log.e(TAG, "获取Two下拉Data失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取Two下拉Data成功2 = " + s);
                        NewTwoXiaLaInfo info=JSONUtils.toObject(s, NewTwoXiaLaInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetShenfenXiaLakuangData(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getxunjiaZhuzhongXialakuang() {
        Subscription subscribe = mModel.getxunjiaZhuzhongXialakuang()
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
                        Log.e(TAG, "获取Two下拉Data失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取Two下拉Data成功3 = " + s);
                        NewTwoXiaLaInfo info=JSONUtils.toObject(s, NewTwoXiaLaInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetZhuzhongXiaLakuangData(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void upxunjia(String DanHao, int ShenFenID, int NianLingID, String XingMing, String WeiXin, int ZhuZhongDianID, double PingGuPrice) {
        Subscription subscribe = mModel.upxunjia(DanHao,ShenFenID,NianLingID,XingMing,WeiXin,ZhuZhongDianID, PingGuPrice)
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
                        Log.e(TAG, "上传TwoData失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传TwoData成功 = " + s);
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
