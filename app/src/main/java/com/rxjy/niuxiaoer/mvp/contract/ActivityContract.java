package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.ActivityListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/9/18.
 */

public interface ActivityContract {

    interface View extends BaseView {

        void responseActivityListData(List<ActivityListInfo.ActivityList> dataList);

        void responseActivityListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getActivityList(

        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getActivityList(

        );

    }

}
