package com.rxjy.niuxiaoer.mvp.contract;


import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.TokenInfo;
import com.rxjy.niuxiaoer.entity.UserInfo;
import com.rxjy.niuxiaoer.entity.YaoQingMaInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/6.
 */
public interface RegisterContract {

    interface View extends BaseView {

        void responseRegisterData();

        void responseRegisterError(String msg);

        void responseVCcode();

        void responseVerificationCodeDataError(String msg);

        void responseToken(TokenInfo.Token data);

        void responseTokenError(String msg);

        void responseLogin(UserInfo.User data);

        void responseLoginError(String msg);

        void responseYaoQingMa(YaoQingMaInfo info);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getRegister(
                String code,
                String phoneNum,
                String password,
                String invitationCode
        );

        Observable<String> getVerificationCode(
                String phoneNum
        );

        Observable<String> getToken(
                String userNo,
                String password
        );

        Observable<String> getLoginUserInfo(
                String userNo,
                String token
        );
        Observable<String> getYaoQingMa(
                String card
        );
        Observable<String> getMemberInfo(
                 String card,
                 String phone,
                 String shcard);

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getRegister(
                String code,
                String phoneNum,
                String password,
                String invitationCode
        );

        public abstract void getVerificationCode(
                String phoneNum
        );

        public abstract void getToken(
                String userNo,
                String password
        );

        public abstract void getLoginUserInfo(
                String userNo,
                String token
        );

        public abstract void getYaoQingMa(
                String card
        );

        public abstract void getMemberInfo(
                 String card,
                 String phone,
                 String shcard
        );

    }

}
