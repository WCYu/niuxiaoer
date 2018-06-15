package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.AllianceListInfo;
import com.rxjy.niuxiaoer.entity.SubInfo;
import com.rxjy.niuxiaoer.mvp.contract.AllianceContract;
import com.rxjy.niuxiaoer.mvp.model.AllianceModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/8/17.
 */

public class AlliancePresenter extends AllianceContract.Presenter {

    public static final String TAG = "AlliancePresenter";

    public AlliancePresenter(AllianceContract.View mView) {
        this.mView = mView;
        mModel = new AllianceModel();
    }

    @Override
    public void getAllianceList(String cardNo) {
        Subscription subscribe = mModel.getAllianceList(cardNo)
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取联盟列表失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        AllianceListInfo info = JSONUtils.toObject(s, AllianceListInfo.class);
                        if (info.getStatusCode() == 0) {
                            AllianceListInfo.AllianceInfo data = info.getBody();
                            List<AllianceListInfo.AllianceInfo.Alliance> dataList = data.getTable();
                            mView.responseAllianceData(data);
                            mView.responseAllianceListData(dataList);
                        } else {
                            mView.responseAllianceListDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void joinUnion(String cardNo, String superiorCard) {
        Subscription subscribe = mModel.joinUnion(cardNo, superiorCard)
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
                        Log.e(TAG, "加入联盟失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseJoinUnion();
                        } else {
                            mView.responseJoinUnionError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
