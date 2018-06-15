package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.GetClientMsgList;
import com.rxjy.niuxiaoer.entity.GetNewShouyeInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface GetClientMsgListContract {

    interface View extends BaseView {

        void GetClientMsgList(List<GetClientMsgList.Body> body);

        void GetClientMsgListerror(String msg);

        void GetNewShouyeData(GetNewShouyeInfo.BodyBean info);

        void GetNewShouyeDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> GetClientMsgList(
                String cardNo,
                String state,
                String serviceType,
                String seek
        );

        Observable<String> delClientInfo(
                String clientID
        );

        Observable<String> getNewShouyeData(
                String Card,
                String Key
        );


    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void GetClientMsgList(
                String cardNo,
                String state,
                String serviceType,
                String seek
        );

        public abstract void delClientInfo(
                String clientID
        );

        public abstract void GetClientMsgList2(
                String cardNo,
                String state,
                String serviceType,
                String seek
        );

        public abstract void getNewShouyeData(
                String Card,
                String Key
        );


    }

}
