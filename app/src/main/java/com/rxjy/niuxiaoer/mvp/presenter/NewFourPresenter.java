package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.NerFourInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.mvp.contract.NewFourContract;
import com.rxjy.niuxiaoer.mvp.model.NewFourModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/13.
 */

public class NewFourPresenter extends NewFourContract.Presenter {

    public static final String TAG = "NewFourPresenter";

    public NewFourPresenter(NewFourContract.View mView) {
        this.mView = mView;
        mModel = new NewFourModel();
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
                        Log.e(TAG, "获取FourData失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取FourData成功 = " + s);
                        NerFourInfo info= JSONUtils.toObject(s, NerFourInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetData(info);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void upxunjia(String DanHao, String LiangFangDiZhi, int ZhuangXiuXuQiu, String YuJiLiangFang, String GongQi, double ZhuangXiuYuSuan, double PingGuPrice, int ZhaoBiao, String YuJiZhuangXiuShiJian) {
        Subscription subscribe = mModel.upxunjia(DanHao,LiangFangDiZhi,ZhuangXiuXuQiu,YuJiLiangFang,GongQi,ZhuangXiuYuSuan,PingGuPrice,ZhaoBiao,YuJiZhuangXiuShiJian)
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
                        Log.e(TAG, "上传FourData失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "上传FourData成功 = " + s);
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
