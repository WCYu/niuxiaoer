package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.SubInfo;
import com.rxjy.niuxiaoer.entity.TokenInfo;
import com.rxjy.niuxiaoer.entity.UserInfo;
import com.rxjy.niuxiaoer.entity.YaoQingMaInfo;
import com.rxjy.niuxiaoer.mvp.contract.RegisterContract;
import com.rxjy.niuxiaoer.mvp.model.RegisterModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by AAA on 2017/7/27.
 */

public class RegisterPresenter extends RegisterContract.Presenter {

    public static final String TAG = "RegisterPresenter";

    public RegisterPresenter(RegisterContract.View mView) {
        this.mView = mView;
        mModel = new RegisterModel();
    }

    @Override
    public void getRegister(String code, String phoneNum, String password, final String invitationCode) {
        Subscription subscribe = mModel.getRegister(code, phoneNum, password, invitationCode)
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
                        Log.e(TAG, "注册失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                            mView.responseRegisterData();
                        } else {
                            mView.responseRegisterError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getVerificationCode(String phoneNum) {
        Subscription subscribe = mModel.getVerificationCode(phoneNum)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取验证码失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        SubInfo info = JSONUtils.toObject(s, SubInfo.class);
                        if (info.getStatusCode() == 0) {
                           mView.responseVCcode();
                        } else {
                            mView.responseVerificationCodeDataError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getToken(String userNo, String password) {
        Subscription subscribe = mModel.getToken(userNo, password)
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
                        Log.e(TAG, "获取Token失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        TokenInfo info = JSONUtils.toObject(s, TokenInfo.class);
                        if (info.getStatusCode() == 0) {
                            TokenInfo.Token data = info.getBody();
                            mView.responseToken(data);
                        } else {
                            mView.responseTokenError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getLoginUserInfo(String userNo, String token) {
        Subscription subscribe = mModel.getLoginUserInfo(userNo, token)
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
                        Log.e(TAG, "获取用户信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        UserInfo info = JSONUtils.toObject(s, UserInfo.class);
                        if (info.getStatusCode() == 0) {
                            UserInfo.User data = info.getBody();
                            mView.responseLogin(data);
                        } else {
                            mView.responseLoginError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getYaoQingMa(String card) {
        Subscription subscribe = mModel.getYaoQingMa(card)
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
                        Log.e(TAG, "获取邀请码信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取邀请码信息成功 = " + s);
                        YaoQingMaInfo info=JSONUtils.toObject(s, YaoQingMaInfo.class);
                        mView.responseYaoQingMa(info);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getMemberInfo(String card, String phone, String shcard) {
        Subscription subscribe = mModel.getYaoQingMa(card)
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
                        Log.e(TAG, "绑定失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "绑定成功 = " + s);
                    }
                });
        addSubscribe(subscribe);
    }
}
