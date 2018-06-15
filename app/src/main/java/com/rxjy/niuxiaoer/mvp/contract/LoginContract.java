package com.rxjy.niuxiaoer.mvp.contract;


import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.TokenInfo;
import com.rxjy.niuxiaoer.entity.UserInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/21.
 */
public interface LoginContract
{

    interface View extends BaseView
    {

        void responseToken(TokenInfo.Token data);

        void responseTokenError(String msg);

        void responseLogin(UserInfo.User data);

        void responseLoginError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {
        Observable<String> getToken(
                String userNo,
                String password
        );

        Observable<String> getLoginUserInfo(
                String userNo,
                String token
        );
    }

    abstract class Presenter extends BasePresenter<View, Model>
    {
        public abstract void getToken(
                String userNo,
                String password
        );

        public abstract void getLoginUserInfo(
                String userNo,
                String token
        );
    }

}
