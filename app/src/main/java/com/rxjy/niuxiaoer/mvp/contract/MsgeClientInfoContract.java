package com.rxjy.niuxiaoer.mvp.contract;



import com.rxjy.niuxiaoer.commons.base.BaseModel;
import com.rxjy.niuxiaoer.commons.base.BasePresenter;
import com.rxjy.niuxiaoer.commons.base.BaseView;
import com.rxjy.niuxiaoer.entity.FenGongSiInfo;
import com.rxjy.niuxiaoer.entity.GetClientDetailInfo;
import com.rxjy.niuxiaoer.entity.MsgeClientTypeInfo;
import com.rxjy.niuxiaoer.entity.TcInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/6/30.
 */
public interface MsgeClientInfoContract
{

    interface View extends BaseView
    {

        void responseTc(List<TcInfo.BodyBean.TC> dataList);

        void responseClientType(List<TcInfo.BodyBean.ClientType> dataList);

        void responseTcError(String msg);

        void responseOrdersDetailData(GetClientDetailInfo.BodyBean data);

        void responseOrdersDetailDataError(String msg);

        void responseClientTypeData(MsgeClientTypeInfo.ClientType data);

        void responseClientTypeDataError(String msg);

        void responseSubClientInfoData();

        void responseSubClientInfoDataError(String msg);

        void responseSaveClientInfoData();

        void responseSaveClientInfoDataError(String msg);

        void responseFenGongSi(List<FenGongSiInfo.BodyBean> bodyBean);

        void showDialog();

        void hideDialog();
        void hideDialog2();

    }

    interface Model extends BaseModel
    {
        Observable<String> getTc();
        Observable<String> getClientType();

        Observable<String> getOrdersDetail(
                int customerID
        );

        Observable<String> saveOrdersDetail(
                int customID,
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

        Observable<String> subOrdersDetail(
                int customerID,
                String cardNo,
                int type,
                int state,
                int filialeID,
                String clientName,
                String phoneNum,
                String companyName,
                double priceUnit,
                double acreage,
                String businessAddress,
                String measureAddress,
                int ornamentTime,
                int timeProject,
                String startTime,
                String endTime,
                String measureTime,
                int clientDemandOne,
                int clientDemandTwo,
                int resourceState,
                int houseState,
                int administration,
                int desDemand,
                int transactionType,
                int limeLight
        );

        Observable<String> getFenGongSi(
        );

    }

    abstract class Presenter extends BasePresenter<View, Model>
    {
        public abstract void getTc();

        public abstract void getClientType();

        public abstract void getOrdersDetail(
                int customerID
        );

        public abstract void saveOrdersDetail(
                int customID,
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

        public abstract void subOrdersDetail(
                int customerID,
                String cardNo,
                int type,
                int state,
                int filialeID,
                String clientName,
                String phoneNum,
                String companyName,
                double priceUnit,
                double acreage,
                String businessAddress,
                String measureAddress,
                int ornamentTime,
                int timeProject,
                String startTime,
                String endTime,
                String measureTime,
                int clientDemandOne,
                int clientDemandTwo,
                int resourceState,
                int houseState,
                int administration,
                int desDemand,
                int transactionType,
                int limeLight
        );
        public abstract void getFenGongSi();
    }

}
