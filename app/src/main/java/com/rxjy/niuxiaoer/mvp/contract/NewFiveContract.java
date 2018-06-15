package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.NewFiveInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public interface NewFiveContract {
    interface View extends BaseView {

        void responseGetData(NewFiveInfo info);

        void responseGetDataError(String msg);

        void responseUpData(UpPartAddInfo info);

        void responseUpDataError(String msg);

        void responseUpXinxi(UpPartAddInfo info);

        void responseUpXinxiError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        //获取数据
        Observable<String> getxunjia(
                String DanHao
        );

        //上传数据
        Observable<String> upxunjia(
              String DanHao,
              int QiYeGuiMoID,
              String BuildName,
              String LouPanQiZuo,
              double PingGuPrice,
              int SubmitType
        );

        Observable<String> UpBaoCunOrSubmit(
                String DanHao,
                String Phone,
                String XingMing,
                int SubmitType
        );



    }

    abstract class Presenter extends BasePresenter<NewFiveContract.View,NewFiveContract.Model>
    {
        //获取数据
        public abstract void getxunjia(
                String DanHao
        );


        //上传数据
        public abstract void upxunjia(
                String DanHao,
                int QiYeGuiMoID,
                String BuildName,
                String LouPanQiZuo,
                double PingGuPrice,
                int SubmitType
        );

        public abstract void  UpBaoCunOrSubmit(
                String DanHao,
                String Phone,
                String XingMing,
                int SubmitType
        );

    }

}
