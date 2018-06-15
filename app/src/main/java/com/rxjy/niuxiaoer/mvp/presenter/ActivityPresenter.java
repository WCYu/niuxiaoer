package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.ActivityListInfo;
import com.rxjy.niuxiaoer.mvp.contract.ActivityContract;
import com.rxjy.niuxiaoer.mvp.model.ActivityModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/18.
 */

public class ActivityPresenter extends ActivityContract.Presenter {

    public static final String TAG = "ActivityPresenter";

    public ActivityPresenter(ActivityContract.View mView) {
        this.mView = mView;
        mModel = new ActivityModel();
    }

    @Override
    public void getActivityList() {
        Subscription subscribe = mModel.getActivityList()
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
                        Log.e(TAG, "获取活动列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        ActivityListInfo info = JSONUtils.toObject(s, ActivityListInfo.class);
                        if (info.getStatusCode() == 0) {
                            List<ActivityListInfo.ActivityList> dataList = info.getBody();
                            mView.responseActivityListData(dataList);
                        } else {
                            mView.responseActivityListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
