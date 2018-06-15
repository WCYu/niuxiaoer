package com.rxjy.niuxiaoer.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */

public class GetNewShouyeInfo implements Serializable{


    /**
     * StatusCode : 0
     * StatusMsg : 成功
     * Body : {"DataList":[{"DanHao":"45-129","FenGongSiMingCheng":"集团","JiBen":"办公","KeHu":"副总","FangYuan":"123.00","XuQiu":"123.00","ShiJian":"2017-10-19","PingGuPrice":1500,"ZhuangTai":"未提交","ZhuangTaiID":1,"STATUS":0},{"DanHao":"45-124","FenGongSiMingCheng":"集团","JiBen":"该好好","KeHu":"50岁以上","FangYuan":"已定","XuQiu":"二次改造","ShiJian":"2017-10-19","PingGuPrice":950,"ZhuangTai":"未提交","ZhuangTaiID":1,"STATUS":0},{"DanHao":"45-92","FenGongSiMingCheng":"集团","JiBen":"去","KeHu":"去","FangYuan":"100.00","XuQiu":"简装","ShiJian":"2017-10-18","PingGuPrice":2750,"ZhuangTai":"未通过","ZhuangTaiID":4,"STATUS":0},{"DanHao":"45-83","FenGongSiMingCheng":"集团","JiBen":"测试公司","KeHu":"呵呵","FangYuan":"已定","XuQiu":"简装","ShiJian":"2017-10-18","PingGuPrice":3000,"ZhuangTai":"待受理","ZhuangTaiID":2,"STATUS":0},{"DanHao":"45-57","FenGongSiMingCheng":"集团","JiBen":"121","KeHu":"12","FangYuan":"未定","XuQiu":"","ShiJian":"2017-10-18","PingGuPrice":3100,"ZhuangTai":"已完成","ZhuangTaiID":3,"STATUS":0}],"DataTotal":[{"MemRank":"Num1","FenGongSiMingCheng":"重庆会员","ShouJi":"137****4521","Money":2000},{"MemRank":"Num2","FenGongSiMingCheng":"天津会员","ShouJi":"158****6055","Money":2500},{"MemRank":"Num3","FenGongSiMingCheng":"武汉会员","ShouJi":"159****8276","Money":3000},{"MemRank":"Num4","FenGongSiMingCheng":"重庆会员","ShouJi":"137****4521","Money":2000},{"MemRank":"Num5","FenGongSiMingCheng":"重庆会员","ShouJi":"185****3004","Money":2000},{"MemRank":"Num6","FenGongSiMingCheng":"济南会员","ShouJi":"158****1127","Money":3000}]}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean implements Serializable{
        private List<DataListBean> DataList;
        private List<DataTotalBean> DataTotal;

        public List<DataListBean> getDataList() {
            return DataList;
        }

        public void setDataList(List<DataListBean> DataList) {
            this.DataList = DataList;
        }

        public List<DataTotalBean> getDataTotal() {
            return DataTotal;
        }

        public void setDataTotal(List<DataTotalBean> DataTotal) {
            this.DataTotal = DataTotal;
        }

        public static class DataListBean implements Serializable{
            /**
             * DanHao : 45-129
             * FenGongSiMingCheng : 集团
             * JiBen : 办公
             * KeHu : 副总
             * FangYuan : 123.00
             * XuQiu : 123.00
             * ShiJian : 2017-10-19
             * PingGuPrice : 1500.0
             * ZhuangTai : 未提交
             * ZhuangTaiID : 1
             * STATUS : 0
             */

            private String DanHao;
            private String FenGongSiMingCheng;
            private String JiBen;
            private String KeHu;
            private String FangYuan;
            private String XuQiu;
            private String ShiJian;
            private double PingGuPrice;
            private String ZhuangTai;
            private int ZhuangTaiID;
            private int STATUS;

            public String getDanHao() {
                return DanHao;
            }

            public void setDanHao(String DanHao) {
                this.DanHao = DanHao;
            }

            public String getFenGongSiMingCheng() {
                return FenGongSiMingCheng;
            }

            public void setFenGongSiMingCheng(String FenGongSiMingCheng) {
                this.FenGongSiMingCheng = FenGongSiMingCheng;
            }

            public String getJiBen() {
                return JiBen;
            }

            public void setJiBen(String JiBen) {
                this.JiBen = JiBen;
            }

            public String getKeHu() {
                return KeHu;
            }

            public void setKeHu(String KeHu) {
                this.KeHu = KeHu;
            }

            public String getFangYuan() {
                return FangYuan;
            }

            public void setFangYuan(String FangYuan) {
                this.FangYuan = FangYuan;
            }

            public String getXuQiu() {
                return XuQiu;
            }

            public void setXuQiu(String XuQiu) {
                this.XuQiu = XuQiu;
            }

            public String getShiJian() {
                return ShiJian;
            }

            public void setShiJian(String ShiJian) {
                this.ShiJian = ShiJian;
            }

            public double getPingGuPrice() {
                return PingGuPrice;
            }

            public void setPingGuPrice(double PingGuPrice) {
                this.PingGuPrice = PingGuPrice;
            }

            public String getZhuangTai() {
                return ZhuangTai;
            }

            public void setZhuangTai(String ZhuangTai) {
                this.ZhuangTai = ZhuangTai;
            }

            public int getZhuangTaiID() {
                return ZhuangTaiID;
            }

            public void setZhuangTaiID(int ZhuangTaiID) {
                this.ZhuangTaiID = ZhuangTaiID;
            }

            public int getSTATUS() {
                return STATUS;
            }

            public void setSTATUS(int STATUS) {
                this.STATUS = STATUS;
            }
        }

        public static class DataTotalBean {
            /**
             * MemRank : Num1
             * FenGongSiMingCheng : 重庆会员
             * ShouJi : 137****4521
             * Money : 2000.0
             */

            private String MemRank;
            private String FenGongSiMingCheng;
            private String ShouJi;
            private double Money;

            public String getMemRank() {
                return MemRank;
            }

            public void setMemRank(String MemRank) {
                this.MemRank = MemRank;
            }

            public String getFenGongSiMingCheng() {
                return FenGongSiMingCheng;
            }

            public void setFenGongSiMingCheng(String FenGongSiMingCheng) {
                this.FenGongSiMingCheng = FenGongSiMingCheng;
            }

            public String getShouJi() {
                return ShouJi;
            }

            public void setShouJi(String ShouJi) {
                this.ShouJi = ShouJi;
            }

            public double getMoney() {
                return Money;
            }

            public void setMoney(double Money) {
                this.Money = Money;
            }
        }
    }
}
