package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.NewOneInfo;
import com.rxjy.niuxiaoer.entity.NewOneXiaLaInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfoNew;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/12.
 */

public interface NewOneContract {

    interface View extends BaseView
    {

        void responseGetData(NewOneInfo info);

        void responseGetDataError(String msg);

        void responseUpData(UpPartAddInfoNew info);

        void responseUpDataError(String msg);

        void responseGetXiaLakuangData(NewOneXiaLaInfo info);

        void responseGetXiaLakuangDataError(String msg);

        void responsephone(String msg);

        void responsephoneError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel
    {
        //获取数据
        Observable<String> getjiben(
                String DanHao
        );

        //获取行业下拉框数据
        Observable<String> getjibenXialakuang(
        );

        //上传数据
        Observable<String> upjiben(
                String DanHao,
                String GongSiMingCheng,
                String BanGongDiDian,
                int LeiXingYi,
                double PingGuPrice,
                String Phone,
                String XingMing,
                String SparePhone
        );

        Observable<String> getphone(
                String phoneNum
        );

    }

    abstract class Presenter extends BasePresenter<View,Model>
    {
        //获取数据
        public abstract void getjiben(
                String DanHao
        );

        //获取行业下拉框数据
        public abstract void getjibenXialakuang(
        );

        //上传数据
        public abstract void upjiben(
                String DanHao,
                String GongSiMingCheng,
                String BanGongDiDian,
                int LeiXingYi,
                double PingGuPrice,
                String Phone,
                String XingMing,
                String SparePhone
        );

        public abstract void getphone(
                String phoneNum
        );

    }

}
