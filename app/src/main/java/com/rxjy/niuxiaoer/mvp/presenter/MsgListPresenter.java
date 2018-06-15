package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.MsgListInfo;
import com.rxjy.niuxiaoer.mvp.contract.MsgListContract;
import com.rxjy.niuxiaoer.mvp.model.MsgListModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/9/18.
 */

public class MsgListPresenter extends MsgListContract.Presenter {

    public static final String TAG = "MsgListPresenter";

    public MsgListPresenter(MsgListContract.View mView) {
        this.mView = mView;
        mModel = new MsgListModel();
    }

    @Override
    public void getMsgList(String cardNo) {
        Subscription subscribe = mModel.getMsgList(cardNo)
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
                        Log.e(TAG, "获取消息列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        MsgListInfo info = JSONUtils.toObject(s, MsgListInfo.class);
                        if (info.getStatusCode() == 0) {
                            List<MsgListInfo.MsgList> dataList = info.getBody();
                            mView.responseMsgListData(dataList);
                        } else {
                            mView.responseMsgListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
