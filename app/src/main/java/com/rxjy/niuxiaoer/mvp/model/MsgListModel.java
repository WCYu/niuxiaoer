package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.MsgListContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by AAA on 2017/9/18.
 */

public class MsgListModel implements MsgListContract.Model {
    @Override
    public Observable<String> getMsgList(String cardNo) {
        return ApiEngine.getInstance().getSwApiService()
                .getMsgList(cardNo)
                .compose(RxSchedulers.<String>switchThread());
    }
}
