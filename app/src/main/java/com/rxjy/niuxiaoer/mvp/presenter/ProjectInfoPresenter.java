package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.ProjectInfo;
import com.rxjy.niuxiaoer.mvp.contract.ProjectInfoContract;
import com.rxjy.niuxiaoer.mvp.model.ProjectInfoModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ProjectInfoPresenter extends ProjectInfoContract.Presenter {

    public static final String TAG = "ProjectInfoPresenter";

    public ProjectInfoPresenter(ProjectInfoContract.View mView) {
        this.mView = mView;
        mModel = new ProjectInfoModel();
    }
    @Override
    public void getProjectInfo(String DanHao) {
        Subscription subscribe = mModel.getProjectInfo(DanHao)
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
                        ProjectInfo info=JSONUtils.toObject(s, ProjectInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseGetData(info.getBody());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
