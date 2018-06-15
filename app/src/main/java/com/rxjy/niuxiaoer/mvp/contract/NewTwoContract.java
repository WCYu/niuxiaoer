package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.NewTwoInfo;
import com.rxjy.niuxiaoer.entity.NewTwoXiaLaInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/12.
 */

public interface NewTwoContract {

    interface View extends BaseView
    {

        void responseGetData(NewTwoInfo info);

        void responseGetDataError(String msg);

        void responseUpData(UpPartAddInfo info);

        void responseUpDataError(String msg);

        void responseGetXiaLakuangData(NewTwoXiaLaInfo info);

        void responseGetXiaLakuangDataError(String msg);

        void responseGetShenfenXiaLakuangData(NewTwoXiaLaInfo info);

        void responseGetShenfenXiaLakuangDataError(String msg);

        void responseGetZhuzhongXiaLakuangData(NewTwoXiaLaInfo info);

        void responseGetZhuzhongXiaLakuangDataError(String msg);


        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {
        //获取数据
        Observable<String> getxunjia(
                String DanHao
        );

        //获取行业下拉框数据
        Observable<String> getxunjiaXialakuang(
        );

        Observable<String> getxunjiaShenfenXialakuang(
        );

        Observable<String> getxunjiaZhuzhongXialakuang(
        );

        //上传数据
        Observable<String> upxunjia(
                String DanHao,
                int ShenFenID,
                int NianLingID,
                String XingMing,
                String WeiXin,
                int ZhuZhongDianID,
                double PingGuPrice
        );


    }

    abstract class Presenter extends BasePresenter<NewTwoContract.View,NewTwoContract.Model>
    {
        //获取数据
        public abstract void getxunjia(
                String DanHao
        );

        //获取行业下拉框数据
        public abstract void getxunjiaXialakuang(
        );

        public abstract void getxunjiaShenfenXialakuang(
        );

        public abstract void getxunjiaZhuzhongXialakuang(
        );

        //上传数据
        public abstract void upxunjia(
                String DanHao,
                int ShenFenID,
                int NianLingID,
                String XingMing,
                String WeiXin,
                int ZhuZhongDianID,
                double PingGuPrice
        );

    }

}
