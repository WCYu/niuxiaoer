package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.GetKehuXingmingInfo;
import com.rxjy.niuxiaoer.entity.UpPartAddInfo;

import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public interface SubmitDialogContract {

    interface View extends BaseView {

        void responseGetName(GetKehuXingmingInfo info);

        void responseGetNameError(String msg);

        void responseUpXinxi(UpPartAddInfo info);

        void responseUpXinxiError(UpPartAddInfo msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {

        Observable<String> getName(
                String DanHao
        );
        Observable<String> UpBaoCunOrSubmit(
                 String DanHao,
                 String Phone,
                 String XingMing,
                 int SubmitType
        );


    }

    abstract class Presenter extends BasePresenter<SubmitDialogContract.View, SubmitDialogContract.Model> {

        public abstract void  getName(
                String DanHao
        );
        public abstract void  UpBaoCunOrSubmit(
                String DanHao,
                String Phone,
                String XingMing,
                int SubmitType
        );
    }

}
