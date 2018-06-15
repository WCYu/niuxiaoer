package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.GetDanHaoInfo;
import com.rxjy.niuxiaoer.entity.GetNewZDPrice;
import com.rxjy.niuxiaoer.entity.IsReadStateInfo;

import rx.Observable;

/**
 * Created by AAA on 2017/8/17.
 */

public interface MainContract {

    interface View extends BaseView {

        void responseStateData(IsReadStateInfo.IsReadState data);

        void responseMineStateData(IsReadStateInfo.IsReadState data);

        void responseGetZiDuanPrice(GetNewZDPrice info);

        void responseGetZiDuanPriceError(String msg);

        void GetNewDanHao(GetDanHaoInfo info);

        void GetNewDanHaoError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getTabState(
                String card
        );

        Observable<String> getMineState(
                String card
        );

        Observable<String> getNewDanHao(
                String Card
        );

        Observable<String> getNewZiDuanPrice(

        );


    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getTabState(
                String card
        );

        public abstract void getMineState(
                String card
        );

        public abstract void getNewDanHao(
                String Card
        );

        public abstract void getNewZiDuanPrice(

        );

    }

}
