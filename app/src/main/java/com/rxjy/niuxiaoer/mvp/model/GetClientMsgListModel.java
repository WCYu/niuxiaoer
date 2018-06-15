package com.rxjy.niuxiaoer.mvp.model;

import com.rxjy.niuxiaoer.api.ApiEngine;
import com.rxjy.niuxiaoer.mvp.contract.GetClientMsgListContract;
import com.rxjy.niuxiaoer.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/31.
 */
public class GetClientMsgListModel implements GetClientMsgListContract.Model {
    @Override
    public Observable<String> GetClientMsgList(String cardNo, String state, String serviceType, String seek) {
        return ApiEngine.getInstance().getSwApiService().GetClientMsgList(cardNo, state, serviceType, seek)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> delClientInfo(String clientID) {
        return ApiEngine.getInstance().getSwApiService()
                .delClientInfo(clientID)
                .compose(RxSchedulers.<String>switchThread());
    }

    @Override
    public Observable<String> getNewShouyeData(String Card,String key) {
        return ApiEngine.getInstance().getSwApiService()
                .getNewShouyeData(Card,key)
                .compose(RxSchedulers.<String>switchThread());
    }


}
