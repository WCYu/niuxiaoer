package com.rxjy.niuxiaoer.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/3.
 */

public class GetClientDetailInfo implements Serializable{


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : {"DanHao":"12-197065","KeHuBaseID":606459,"DiQu":"12","XingMing":"孙豪测试","XingBie":0,"ShouJiHaoYi":"15578954464","ShouJiHaoEr":"","ShouJiHaoSan":"","GongSiMingCheng":"测","BanGongDiDian":"","YouXiang":"","LeiXingYi":0,"LeiXingEr":1,"LeiXingErName":"客户办公","LeiXingYiName":"","DiQuName":null,"FangYuan":1,"MianJi":12,"YuJiLiangFang":"1900-01-01 00:00:00","LiangFangDiZhi":"68465","YuJiZhuangXiuShiJian":"1900-01-01 00:00:00","ZhuangXiuYuSuan":0,"MianZuQi":0,"ChengJiaoLeiXing":0,"XiangMuShuXing":0,"ZuQiKaiShi":"1900-01-01 00:00:00","ZuQiJieShu":"1900-01-01 00:00:00","BeiZhu":"5640","YuJiZhuangXiu":0,"Duration":0,"Decoration_demand":0,"JianYiSheJiShiXingMing":"","ShenFenID":0,"ZhuZhongDianID":0}
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

    public static class BodyBean {
        /**
         * DanHao : 12-197065
         * KeHuBaseID : 606459
         * DiQu : 12
         * XingMing : 孙豪测试
         * XingBie : 0
         * ShouJiHaoYi : 15578954464
         * ShouJiHaoEr :
         * ShouJiHaoSan :
         * GongSiMingCheng : 测
         * BanGongDiDian :
         * YouXiang :
         * LeiXingYi : 0
         * LeiXingEr : 1
         * LeiXingErName : 客户办公
         * LeiXingYiName :
         * DiQuName : null
         * FangYuan : 1
         * MianJi : 12.0
         * YuJiLiangFang : 1900-01-01 00:00:00
         * LiangFangDiZhi : 68465
         * YuJiZhuangXiuShiJian : 1900-01-01 00:00:00
         * ZhuangXiuYuSuan : 0.0
         * MianZuQi : 0
         * ChengJiaoLeiXing : 0
         * XiangMuShuXing : 0
         * ZuQiKaiShi : 1900-01-01 00:00:00
         * ZuQiJieShu : 1900-01-01 00:00:00
         * BeiZhu : 5640
         * YuJiZhuangXiu : 0
         * Duration : 0
         * Decoration_demand : 0
         * JianYiSheJiShiXingMing :
         * ShenFenID : 0
         * ZhuZhongDianID : 0
         */

        private String DanHao;
        private int KeHuBaseID;
        private String DiQu;
        private String XingMing;
        private int XingBie;
        private String ShouJiHaoYi;
        private String ShouJiHaoEr;
        private String ShouJiHaoSan;
        private String GongSiMingCheng;
        private String BanGongDiDian;
        private String YouXiang;
        private int LeiXingYi;
        private int LeiXingEr;
        private String LeiXingErName;
        private String LeiXingYiName;
        private Object DiQuName;
        private int FangYuan;
        private double MianJi;
        private String YuJiLiangFang;
        private String LiangFangDiZhi;
        private String YuJiZhuangXiuShiJian;
        private double ZhuangXiuYuSuan;
        private int MianZuQi;
        private int ChengJiaoLeiXing;
        private int XiangMuShuXing;
        private String ZuQiKaiShi;
        private String ZuQiJieShu;
        private String BeiZhu;
        private int YuJiZhuangXiu;
        private int Duration;
        private int Decoration_demand;
        private String JianYiSheJiShiXingMing;
        private int ShenFenID;
        private int ZhuZhongDianID;
        private String PackageName;
        private int Commission;
        private int MeasureMoney;
        private int Package_type;
        private String DaHuiYuanYin;

        public String getDaHuiYuanYin() {
            return DaHuiYuanYin;
        }

        public void setDaHuiYuanYin(String daHuiYuanYin) {
            DaHuiYuanYin = daHuiYuanYin;
        }

        public int getPackage_type() {
            return Package_type;
        }

        public void setPackage_type(int package_type) {
            Package_type = package_type;
        }

        public int getCommission() {
            return Commission;
        }

        public void setCommission(int commission) {
            Commission = commission;
        }

        public int getMeasureMoney() {
            return MeasureMoney;
        }

        public void setMeasureMoney(int measureMoney) {
            MeasureMoney = measureMoney;
        }

        public String getPackageName() {
            return PackageName;
        }

        public void setPackageName(String packageName) {
            PackageName = packageName;
        }

        public String getPackageID() {
            return PackageID;
        }

        public void setPackageID(String packageID) {
            PackageID = packageID;
        }

        private String PackageID;


        public String getDanHao() {
            return DanHao;
        }

        public void setDanHao(String DanHao) {
            this.DanHao = DanHao;
        }

        public int getKeHuBaseID() {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(int KeHuBaseID) {
            this.KeHuBaseID = KeHuBaseID;
        }

        public String getDiQu() {
            return DiQu;
        }

        public void setDiQu(String DiQu) {
            this.DiQu = DiQu;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String XingMing) {
            this.XingMing = XingMing;
        }

        public int getXingBie() {
            return XingBie;
        }

        public void setXingBie(int XingBie) {
            this.XingBie = XingBie;
        }

        public String getShouJiHaoYi() {
            return ShouJiHaoYi;
        }

        public void setShouJiHaoYi(String ShouJiHaoYi) {
            this.ShouJiHaoYi = ShouJiHaoYi;
        }

        public String getShouJiHaoEr() {
            return ShouJiHaoEr;
        }

        public void setShouJiHaoEr(String ShouJiHaoEr) {
            this.ShouJiHaoEr = ShouJiHaoEr;
        }

        public String getShouJiHaoSan() {
            return ShouJiHaoSan;
        }

        public void setShouJiHaoSan(String ShouJiHaoSan) {
            this.ShouJiHaoSan = ShouJiHaoSan;
        }

        public String getGongSiMingCheng() {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(String GongSiMingCheng) {
            this.GongSiMingCheng = GongSiMingCheng;
        }

        public String getBanGongDiDian() {
            return BanGongDiDian;
        }

        public void setBanGongDiDian(String BanGongDiDian) {
            this.BanGongDiDian = BanGongDiDian;
        }

        public String getYouXiang() {
            return YouXiang;
        }

        public void setYouXiang(String YouXiang) {
            this.YouXiang = YouXiang;
        }

        public int getLeiXingYi() {
            return LeiXingYi;
        }

        public void setLeiXingYi(int LeiXingYi) {
            this.LeiXingYi = LeiXingYi;
        }

        public int getLeiXingEr() {
            return LeiXingEr;
        }

        public void setLeiXingEr(int LeiXingEr) {
            this.LeiXingEr = LeiXingEr;
        }

        public String getLeiXingErName() {
            return LeiXingErName;
        }

        public void setLeiXingErName(String LeiXingErName) {
            this.LeiXingErName = LeiXingErName;
        }

        public String getLeiXingYiName() {
            return LeiXingYiName;
        }

        public void setLeiXingYiName(String LeiXingYiName) {
            this.LeiXingYiName = LeiXingYiName;
        }

        public Object getDiQuName() {
            return DiQuName;
        }

        public void setDiQuName(Object DiQuName) {
            this.DiQuName = DiQuName;
        }

        public int getFangYuan() {
            return FangYuan;
        }

        public void setFangYuan(int FangYuan) {
            this.FangYuan = FangYuan;
        }

        public double getMianJi() {
            return MianJi;
        }

        public void setMianJi(double MianJi) {
            this.MianJi = MianJi;
        }

        public String getYuJiLiangFang() {
            return YuJiLiangFang;
        }

        public void setYuJiLiangFang(String YuJiLiangFang) {
            this.YuJiLiangFang = YuJiLiangFang;
        }

        public String getLiangFangDiZhi() {
            return LiangFangDiZhi;
        }

        public void setLiangFangDiZhi(String LiangFangDiZhi) {
            this.LiangFangDiZhi = LiangFangDiZhi;
        }

        public String getYuJiZhuangXiuShiJian() {
            return YuJiZhuangXiuShiJian;
        }

        public void setYuJiZhuangXiuShiJian(String YuJiZhuangXiuShiJian) {
            this.YuJiZhuangXiuShiJian = YuJiZhuangXiuShiJian;
        }

        public double getZhuangXiuYuSuan() {
            return ZhuangXiuYuSuan;
        }

        public void setZhuangXiuYuSuan(double ZhuangXiuYuSuan) {
            this.ZhuangXiuYuSuan = ZhuangXiuYuSuan;
        }

        public int getMianZuQi() {
            return MianZuQi;
        }

        public void setMianZuQi(int MianZuQi) {
            this.MianZuQi = MianZuQi;
        }

        public int getChengJiaoLeiXing() {
            return ChengJiaoLeiXing;
        }

        public void setChengJiaoLeiXing(int ChengJiaoLeiXing) {
            this.ChengJiaoLeiXing = ChengJiaoLeiXing;
        }

        public int getXiangMuShuXing() {
            return XiangMuShuXing;
        }

        public void setXiangMuShuXing(int XiangMuShuXing) {
            this.XiangMuShuXing = XiangMuShuXing;
        }

        public String getZuQiKaiShi() {
            return ZuQiKaiShi;
        }

        public void setZuQiKaiShi(String ZuQiKaiShi) {
            this.ZuQiKaiShi = ZuQiKaiShi;
        }

        public String getZuQiJieShu() {
            return ZuQiJieShu;
        }

        public void setZuQiJieShu(String ZuQiJieShu) {
            this.ZuQiJieShu = ZuQiJieShu;
        }

        public String getBeiZhu() {
            return BeiZhu;
        }

        public void setBeiZhu(String BeiZhu) {
            this.BeiZhu = BeiZhu;
        }

        public int getYuJiZhuangXiu() {
            return YuJiZhuangXiu;
        }

        public void setYuJiZhuangXiu(int YuJiZhuangXiu) {
            this.YuJiZhuangXiu = YuJiZhuangXiu;
        }

        public int getDuration() {
            return Duration;
        }

        public void setDuration(int Duration) {
            this.Duration = Duration;
        }

        public int getDecoration_demand() {
            return Decoration_demand;
        }

        public void setDecoration_demand(int Decoration_demand) {
            this.Decoration_demand = Decoration_demand;
        }

        public String getJianYiSheJiShiXingMing() {
            return JianYiSheJiShiXingMing;
        }

        public void setJianYiSheJiShiXingMing(String JianYiSheJiShiXingMing) {
            this.JianYiSheJiShiXingMing = JianYiSheJiShiXingMing;
        }

        public int getShenFenID() {
            return ShenFenID;
        }

        public void setShenFenID(int ShenFenID) {
            this.ShenFenID = ShenFenID;
        }

        public int getZhuZhongDianID() {
            return ZhuZhongDianID;
        }

        public void setZhuZhongDianID(int ZhuZhongDianID) {
            this.ZhuZhongDianID = ZhuZhongDianID;
        }
    }
}
