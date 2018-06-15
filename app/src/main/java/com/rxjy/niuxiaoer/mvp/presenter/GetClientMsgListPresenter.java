package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.GetClientMsgList;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;
import com.rxjy.niuxiaoer.mvp.contract.GetClientMsgListContract;
import com.rxjy.niuxiaoer.mvp.model.GetClientMsgListModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/7/31.
 */
public class GetClientMsgListPresenter extends GetClientMsgListContract.Presenter {
    public static final String TAG = "GetClientMsgListPresent";

    public GetClientMsgListPresenter(GetClientMsgListContract.View mView) {
        this.mView = mView;
        mModel = new GetClientMsgListModel();
    }

    @Override
    public void GetClientMsgList(String cardNo, String state, String serviceType, String seek) {
        Subscription subscribe = mModel.GetClientMsgList(cardNo, state, serviceType, seek).subscribe(
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
                        Log.e(TAG, "获取信息失败" + e.toString());
                        mView.hideDialog();
                        mView.GetClientMsgListerror("搜索信息失败，请稍后重试");
                    }

                    @Override
                    public void onNext(String s) {
                        GetClientMsgList info = JSONUtils.toObject(s, GetClientMsgList.class);
                        if (info.getStatusCode() == 0) {
                            mView.GetClientMsgList(info.getBody());
                        } else {
                            mView.GetClientMsgListerror(info.getStatusMsg());
                        }
                    }
                }
        );
        addSubscribe(subscribe);
    }

    @Override
    public void delClientInfo(String clientID) {
        Subscription subscribe = mModel.delClientInfo(clientID)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "删除失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void GetClientMsgList2(String cardNo, String state, String serviceType, String seek) {
        Subscription subscribe = mModel.GetClientMsgList(cardNo, state, serviceType, seek).subscribe(
                new Subscriber<String>() {
                    @Override
                    public void onStart() {
                        //mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取信息失败" + e.toString());
                        mView.hideDialog();
                        mView.GetClientMsgListerror("搜索信息失败，请稍后重试");
                    }

                    @Override
                    public void onNext(String s) {

                        Log.e(TAG, "获取信息成功" + s);
                        GetClientMsgList gcml = JSONUtils.toObject(s, GetClientMsgList.class);
                        mView.GetClientMsgList(gcml.getBody());
                    }
                }
        );
        addSubscribe(subscribe);
    }

    @Override
    public void getNewShouyeData(String Card,String key) {
        Subscription subscribe = mModel.getNewShouyeData(Card,key).subscribe(
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
                        Log.e(TAG, "获取new信息失败" + e.toString());
                       mView.GetNewShouyeDataError("获取信息失败");
                    }

                    @Override
                    public void onNext(String s) {

                        Log.e(TAG, "获取new信息成功" + s);
                        GetNewShouyeInfo info=JSONUtils.toObject(s, GetNewShouyeInfo.class);
                        if (info.getStatusCode()==0) {

                            mView.GetNewShouyeData(info.getBody());
                        }
                    }
                }
        );
        addSubscribe(subscribe);
    }


}
