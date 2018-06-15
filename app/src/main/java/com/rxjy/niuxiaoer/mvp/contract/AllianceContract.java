package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.AllianceListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/8/17.
 */

public interface AllianceContract {

    interface View extends BaseView {

        void responseAllianceData(AllianceListInfo.AllianceInfo data);

        void responseAllianceListData(List<AllianceListInfo.AllianceInfo.Alliance> dataList);

        void responseAllianceListDataError(String msg);

        void responseJoinUnion();

        void responseJoinUnionError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getAllianceList(
                String cardNo
        );

        Observable<String> joinUnion(
                String cardNo,
                String superiorCard
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getAllianceList(
                String cardNo
        );

        public abstract void joinUnion(
                String cardNo,
                String superiorCard
        );

    }

}
