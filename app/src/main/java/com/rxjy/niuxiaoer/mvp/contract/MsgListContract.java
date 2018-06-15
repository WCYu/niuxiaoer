package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.MsgListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/9/18.
 */

public interface MsgListContract {

    interface View extends BaseView {

        void responseMsgListData(List<MsgListInfo.MsgList> dataList);

        void responseMsgListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getMsgList(
                String cardNo
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getMsgList(
                String cardNo
        );

    }

}
