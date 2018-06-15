package com.rxjy.niuxiaoer.mvp.contract;

import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.FenGongSiInfo;
import com.rxjy.niuxiaoer.entity.GetClientMsgList;
import com.rxjy.niuxiaoer.entity.TcInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface AddContract {
    interface View extends BaseView{
        void responseTc(List<TcInfo.BodyBean.TC> dataList);

        void responseClientType(List<TcInfo.BodyBean.ClientType> dataList);

        void responseTcError(String msg);

        void responseClientData();

        void responseClientDataError(String msg);

        void responseFenGongSi(List<FenGongSiInfo.BodyBean> bodyBean);

        void showDialog();

        void hideDialog();
        void  showtoast();
        void getClientMsgOne(GetClientMsgList.Body body);
    }
    interface Model extends BaseModel {

        Observable<String> getTc(

        );

        Observable<String> addandsubmit
                (String XingMing,
                 String ShouJiHaoYi,
                 String MianJi,
                 String LeiXingYi,
                 String LeiXingEr,
                 String GongSiMingCheng,
                 String LiangFangDiZhi,
                 String KaHao,
                 String FangYuan,
                 String BeiZhu,
                 String Package_type,
                 String ZhuangTai,
                 int FenGongSiID);

        Observable<String> getFenGongSi(
        );
    }


    abstract class Presenter extends BasePresenter<View, Model>
    {
        public abstract void getTc(

        );


        public abstract void addandsubmit(
                String XingMing,
                String ShouJiHaoYi,
                String MianJi,
                String LeiXingYi,
                String LeiXingEr,
                String GongSiMingCheng,
                String LiangFangDiZhi,
                String KaHao,
                String FangYuan,
                String BeiZhu,
                String Package_type,
                String ZhuangTai,
                int FenGongSiID
        );

        public abstract void getFenGongSi();
    }

}
