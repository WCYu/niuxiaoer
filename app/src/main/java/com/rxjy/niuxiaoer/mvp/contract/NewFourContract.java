package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.NerFourInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public interface NewFourContract {
    interface View extends BaseView {

        void responseGetData(NerFourInfo info);

        void responseGetDataError(String msg);

        void responseUpData(UpPartAddInfo info);

        void responseUpDataError(String msg);

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
                String LiangFangDiZhi,
                int ZhuangXiuXuQiu,
                String YuJiLiangFang,
                String GongQi,
                double ZhuangXiuYuSuan,
                double PingGuPrice,
                int ZhaoBiao,
                String YuJiZhuangXiuShiJian
        );


    }

    abstract class Presenter extends BasePresenter<NewFourContract.View,NewFourContract.Model>
    {
        //获取数据
        public abstract void getxunjia(
                String DanHao
        );


        //上传数据
        public abstract void upxunjia(
                String DanHao,
                String LiangFangDiZhi,
                int ZhuangXiuXuQiu,
                String YuJiLiangFang,
                String GongQi,
                double ZhuangXiuYuSuan,
                double PingGuPrice,
                int ZhaoBiao,
                String YuJiZhuangXiuShiJian
        );

    }

}
