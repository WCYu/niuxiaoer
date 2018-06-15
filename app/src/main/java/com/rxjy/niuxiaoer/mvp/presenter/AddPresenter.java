package com.rxjy.niuxiaoer.mvp.presenter;

import android.util.Log;

import com.rxjy.niuxiaoer.commons.utils.JSONUtils;
import com.rxjy.niuxiaoer.entity.FenGongSiInfo;
import com.rxjy.niuxiaoer.entity.GetClientMsgList;
import com.rxjy.niuxiaoer.entity.TcInfo;
import com.rxjy.niuxiaoer.mvp.contract.AddContract;
import com.rxjy.niuxiaoer.mvp.model.AddModel;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Administrator on 2017/7/28.
 */
public class AddPresenter extends AddContract.Presenter
{
    public static final String TAG = "AddPresenter";

    public AddPresenter(AddContract.View mView) {
        this.mView = mView;
        mModel = new AddModel();
    }


    @Override
    public void getTc() {
        Subscription subscribe = mModel.getTc()
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取套餐类型信息失败 = " + e.toString());
                        onCompleted();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取套餐类型信息成功 = " + s.toString());
                        TcInfo info = JSONUtils.toObject(s, TcInfo.class);
                        if (info.getStatusCode() == 0&&!info.getBody().toString().isEmpty()) {
                            TcInfo.BodyBean data = info.getBody();
                            List<TcInfo.BodyBean.TC> tcList = data.getPackageType();
                            List<TcInfo.BodyBean.ClientType> clientList = data.getCusTomer();
                            mView.responseTc(tcList);
                            mView.responseClientType(clientList);
                        } else {
                            mView.responseTcError(info.getStatusMsg());
                        }
                    }
                });
        addSubscribe(subscribe);
    }



    @Override
    public void addandsubmit(String XingMing, String ShouJiHaoYi, String MianJi, String LeiXingYi,String LeiXingEr, String GongSiMingCheng, String LiangFangDiZhi, String KaHao, String FangYuan, String BeiZhu, String Package_type,String ZhuangTai,int FenGongSiID)
    {
        Subscription subscribe=mModel.addandsubmit(XingMing,ShouJiHaoYi,MianJi,LeiXingYi,LeiXingEr,GongSiMingCheng,LiangFangDiZhi,KaHao,FangYuan,BeiZhu,Package_type,ZhuangTai,FenGongSiID)
                .subscribe(new Subscriber<String>()
                {
                    @Override
                    public void onStart()
                    {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted()
                    {
                        mView.hideDialog();

                    }

                    @Override
                    public void onError(Throwable e)
                    {

                        Log.e(TAG,"上传信息失败 = " + e.toString());
                        mView.hideDialog();
                    }

                    @Override
                    public void onNext(String s)
                    {
                        Log.e(TAG, "结果" +s);
                        GetClientMsgList gcml= JSONUtils.toObject(s, GetClientMsgList.class);
                        if (gcml.getStatusMsg().equals("手机号重复")){
                            mView.showtoast();
                        }

                        mView.getClientMsgOne(gcml.getBody().get(0));

                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void getFenGongSi() {
        Subscription subscribe=mModel.getFenGongSi()
                .subscribe(new Subscriber<String>()
                {
                    @Override
                    public void onStart()
                    {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted()
                    {
                        mView.hideDialog();

                    }

                    @Override
                    public void onError(Throwable e)
                    {

                        Log.e(TAG,"获取分公司信息失败 = " + e.toString());
                        mView.hideDialog();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "获取分公司信息结果" + s);
                        FenGongSiInfo info=JSONUtils.toObject(s, FenGongSiInfo.class);
                        if (info.getStatusCode()==0){
                            mView.responseFenGongSi(info.getBody());
                        }

                    }
                });
        addSubscribe(subscribe);
    }
}
