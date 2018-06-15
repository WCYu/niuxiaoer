package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.ProjectDahuiInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/16.
 */

public interface ProjectDahuiContract {
    interface View extends BaseView
    {

        void responseGetData(List<ProjectDahuiInfo.BodyBean> info);

        void responseGetDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {
        //获取数据
        Observable<String> getProjectDahui(
                String DanHao
        );
    }

    abstract class Presenter extends BasePresenter<ProjectDahuiContract.View,ProjectDahuiContract.Model>
    {
        //获取数据
        public abstract void getProjectDahui(
                String DanHao
        );
    }


}
