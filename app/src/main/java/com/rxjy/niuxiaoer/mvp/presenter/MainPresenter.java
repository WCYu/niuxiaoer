package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.GetDanHaoInfo;
import com.rxjy.niuxiaoer.entity.GetNewZDPrice;
import com.rxjy.niuxiaoer.entity.IsReadStateInfo;
import com.rxjy.niuxiaoer.mvp.contract.MainContract;
import com.rxjy.niuxiaoer.mvp.model.MainModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/17.
 */

public class MainPresenter extends MainContract.Presenter {

    public static final String TAG = "MainPresenter";

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mModel = new MainModel();
    }

    @Override
    public void getTabState(String card) {
        Subscription subscribe = mModel.getTabState(card)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取TAB状态失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        IsReadStateInfo info = JSONUtils.toObject(s, IsReadStateInfo.class);
                        if (info.getStatusCode() == 0) {
                            IsReadStateInfo.IsReadState data = info.getBody();
                            mView.responseStateData(data);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getMineState(String card) {
        Subscription subscribe = mModel.getMineState(card)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取状态失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        IsReadStateInfo info = JSONUtils.toObject(s, IsReadStateInfo.class);
                        if (info.getStatusCode() == 0) {
                            IsReadStateInfo.IsReadState data = info.getBody();
                            mView.responseMineStateData(data);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getNewDanHao(String Card) {
        Subscription subscribe = mModel.getNewDanHao(Card).subscribe(
                new Subscriber<String>() {
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
                        Log.e(TAG, "获取new单号失败" + e.toString());
                        //mView.GetNewDanHaoError("获取信息失败");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取new单号成功" + s);
                         GetDanHaoInfo info=JSONUtils.toObject(s, GetDanHaoInfo.class);
                        if (info.getStatusCode()==0){
                            mView.GetNewDanHao(info);
                        }

                    }
                }
        );
        addSubscribe(subscribe);
    }

    @Override
    public void getNewZiDuanPrice() {
        Subscription subscribe = mModel.getNewZiDuanPrice().subscribe(
                new Subscriber<String>() {
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
                        Log.e(TAG, "获取newPrice失败" + e.toString());
                        //mView.GetNewDanHaoError("获取信息失败");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取newPrice成功" + s);
                        GetNewZDPrice info=JSONUtils.toObject(s, GetNewZDPrice.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetZiDuanPrice(info);
                        }

                    }
                }
        );
        addSubscribe(subscribe);
    }


}
