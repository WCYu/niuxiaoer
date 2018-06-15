package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.MsgDetailInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/9/19.
 */

public interface MsgDetailContract {

    interface View extends BaseView {

        void responseMsgDetailData(MsgDetailInfo.MsgDetail data);

        void responseMsgDetailDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getMsgDetail(
                int xinID
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMsgDetail(
                int xinID
        );

    }

}
