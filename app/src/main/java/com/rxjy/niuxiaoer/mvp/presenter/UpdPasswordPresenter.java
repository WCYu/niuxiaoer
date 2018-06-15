package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.SubInfo;
import com.rxjy.niuxiaoer.mvp.contract.UpdPasswordContract;
import com.rxjy.niuxiaoer.mvp.model.UpdPasswordModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/7/27.
 */

public class UpdPasswordPresenter extends UpdPasswordContract.Presenter {

    public static final String TAG = "UpdPasswordPresenter";

    public UpdPasswordPresenter(UpdPasswordContract.View mView) {
        this.mView = mView;
        mModel = new UpdPasswordModel();
    }

    @Override
    public void updatePwd(String cardNo, String password, String newPassword, String token) {
        Subscription subscribe = mModel.updatePwd(cardNo, password, newPassword, token)
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
                        Log.e(TAG, "修改密码失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responsePwd();
                        } else {
                            mView.responsePwdError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }
}
