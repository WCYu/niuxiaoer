package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;

/**
 * Created by Administrator on 2017/8/2.
 */

public interface YuLanContract {
    interface View extends BaseView {


    }

    interface Model extends BaseModel {


    }

    abstract class Presenter extends BasePresenter<WithdrawDepositContract.View, WithdrawDepositContract.Model> {



    }
}
