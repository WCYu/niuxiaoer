package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.ProjectInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/16.
 */

public interface ProjectInfoContract {

    interface View extends BaseView
    {

        void responseGetData(List<ProjectInfo.BodyBean> info);

        void responseGetDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {
        //获取数据
        Observable<String> getProjectInfo(
                String DanHao
        );
    }

    abstract class Presenter extends BasePresenter<ProjectInfoContract.View,ProjectInfoContract.Model>
    {
        //获取数据
        public abstract void getProjectInfo(
                String DanHao
        );
    }

}
