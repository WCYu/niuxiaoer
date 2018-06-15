package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.ProjectDahuiInfo;
import com.rxjy.niuxiaoer.mvp.contract.ProjectDahuiContract;
import com.rxjy.niuxiaoer.mvp.model.ProjectDahuiModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ProjectDahuiPresenter extends ProjectDahuiContract.Presenter {

    public static final String TAG = "ProjectDahuiPresenter";

    public ProjectDahuiPresenter(ProjectDahuiContract.View mView) {
        this.mView = mView;
        mModel = new ProjectDahuiModel();
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
                        ProjectDahuiInfo info= JSONUtils.toObject(s, ProjectDahuiInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetData(info.getBody());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
