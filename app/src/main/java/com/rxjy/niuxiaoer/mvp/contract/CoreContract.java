package com.rxjy.niuxiaoer.mvp.contract;



import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface CoreContract {

    interface View extends BaseView {

        void responseIP(String ip);

    }

    interface Model extends BaseModel {

        Observable<String> getIP();

        Observable<String> subAppInfo(
                String cardNo,
                String province,
                String city,
                String equipment,
                String ip,
                String netWorkStatus
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getIP();

        public abstract void subAppInfo(
                String cardNo,
                String province,
                String city,
                String equipment,
                String ip,
                String netWorkStatus
        );

    }

}
