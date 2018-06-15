package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.MsgDetailInfo;
import com.rxjy.niuxiaoer.mvp.contract.MsgDetailContract;
import com.rxjy.niuxiaoer.mvp.model.MsgDetailModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/19.
 */

public class MsgDetailPresenter extends MsgDetailContract.Presenter {

    public static final String TAG = "MsgDetailPresenter";

    public MsgDetailPresenter(MsgDetailContract.View mView) {
        this.mView = mView;
        mModel = new MsgDetailModel();
    }

    @Override
    public void getMsgDetail(int xinID) {
        Subscription subscribe = mModel.getMsgDetail(xinID)
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
                        Log.e(TAG, "获取消息详情失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MsgDetailInfo info = JSONUtils.toObject(s, MsgDetailInfo.class);
                        if (info.getStatusCode() == 0) {
                            List<MsgDetailInfo.MsgDetail> dataList = info.getBody();
                            if (dataList.size() != 0)
                                mView.responseMsgDetailData(dataList.get(0));
                        } else {
                            mView.responseMsgDetailDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
