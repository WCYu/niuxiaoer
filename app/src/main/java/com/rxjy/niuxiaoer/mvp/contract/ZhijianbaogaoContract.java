package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.ZhijianYesorNoInfo;
import com.rxjy.niuxiaoer.entity.ZhijianbaogaoInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/16.
 */

public interface ZhijianbaogaoContract {

    interface View extends BaseView
    {

        void responseGetData(List<ZhijianbaogaoInfo.BodyBean> info);

        void responseGetDataError(String msg);

        void responsezhijianYesorNo(List<ZhijianYesorNoInfo.BodyBean> info);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {
        //获取数据
        Observable<String> getProjectDahui(
                String DanHao
        );
        Observable<String> getZhijianhegeInfo(
                 String DanHao,
                 int Type
        );
    }

    abstract class Presenter extends BasePresenter<ZhijianbaogaoContract.View,ZhijianbaogaoContract.Model>
    {
        //获取数据
        public abstract void getProjectDahui(
                String DanHao
        );

        public abstract void getZhijianhegeInfo(
                String DanHao,
                int Type
        );
    }
}
