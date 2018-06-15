package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */

public class GetNewZDPrice {


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"GongSiMingCheng":50,"HangYe":50,"BanGongDiZhi":200,"ShenFen":100,"NianLing":50,"XingMing":200,"WeiXin":200,"ZhuZhong":100,"FangWu":200,"DingFang":100,"MianJi":200,"ChengJiaoLeiXing":50,"MianZuQi":50,"JiaoFangShiJian":50,"XuQiu":200,"ShuXing":100,"YuSuan":200,"GongQi":200,"ZhaoBiao":50,"LiangFangDiZhi":100,"LiangFangShiJian":50,"ZhuangXiuShiJian":100,"GuiMo":50,"LouPan":50,"QiZuo":50,"ShouJi":500}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

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

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * GongSiMingCheng : 50
         * HangYe : 50
         * BanGongDiZhi : 200
         * ShenFen : 100
         * NianLing : 50
         * XingMing : 200
         * WeiXin : 200
         * ZhuZhong : 100
         * FangWu : 200
         * DingFang : 100
         * MianJi : 200
         * ChengJiaoLeiXing : 50
         * MianZuQi : 50
         * JiaoFangShiJian : 50
         * XuQiu : 200
         * ShuXing : 100
         * YuSuan : 200
         * GongQi : 200
         * ZhaoBiao : 50
         * LiangFangDiZhi : 100
         * LiangFangShiJian : 50
         * ZhuangXiuShiJian : 100
         * GuiMo : 50
         * LouPan : 50
         * QiZuo : 50
         * ShouJi : 500
         */

        private int GongSiMingCheng;
        private int HangYe;
        private int BanGongDiZhi;
        private int ShenFen;
        private int NianLing;
        private int XingMing;
        private int WeiXin;
        private int ZhuZhong;
        private int FangWu;
        private int DingFang;
        private int MianJi;
        private int ChengJiaoLeiXing;
        private int MianZuQi;
        private int JiaoFangShiJian;
        private int XuQiu;
        private int ShuXing;
        private int YuSuan;
        private int GongQi;
        private int ZhaoBiao;
        private int LiangFangDiZhi;
        private int LiangFangShiJian;
        private int ZhuangXiuShiJian;
        private int GuiMo;
        private int LouPan;
        private int QiZuo;
        private int ShouJi;

        public int getGongSiMingCheng() {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(int GongSiMingCheng) {
            this.GongSiMingCheng = GongSiMingCheng;
        }

        public int getHangYe() {
            return HangYe;
        }

        public void setHangYe(int HangYe) {
            this.HangYe = HangYe;
        }

        public int getBanGongDiZhi() {
            return BanGongDiZhi;
        }

        public void setBanGongDiZhi(int BanGongDiZhi) {
            this.BanGongDiZhi = BanGongDiZhi;
        }

        public int getShenFen() {
            return ShenFen;
        }

        public void setShenFen(int ShenFen) {
            this.ShenFen = ShenFen;
        }

        public int getNianLing() {
            return NianLing;
        }

        public void setNianLing(int NianLing) {
            this.NianLing = NianLing;
        }

        public int getXingMing() {
            return XingMing;
        }

        public void setXingMing(int XingMing) {
            this.XingMing = XingMing;
        }

        public int getWeiXin() {
            return WeiXin;
        }

        public void setWeiXin(int WeiXin) {
            this.WeiXin = WeiXin;
        }

        public int getZhuZhong() {
            return ZhuZhong;
        }

        public void setZhuZhong(int ZhuZhong) {
            this.ZhuZhong = ZhuZhong;
        }

        public int getFangWu() {
            return FangWu;
        }

        public void setFangWu(int FangWu) {
            this.FangWu = FangWu;
        }

        public int getDingFang() {
            return DingFang;
        }

        public void setDingFang(int DingFang) {
            this.DingFang = DingFang;
        }

        public int getMianJi() {
            return MianJi;
        }

        public void setMianJi(int MianJi) {
            this.MianJi = MianJi;
        }

        public int getChengJiaoLeiXing() {
            return ChengJiaoLeiXing;
        }

        public void setChengJiaoLeiXing(int ChengJiaoLeiXing) {
            this.ChengJiaoLeiXing = ChengJiaoLeiXing;
        }

        public int getMianZuQi() {
            return MianZuQi;
        }

        public void setMianZuQi(int MianZuQi) {
            this.MianZuQi = MianZuQi;
        }

        public int getJiaoFangShiJian() {
            return JiaoFangShiJian;
        }

        public void setJiaoFangShiJian(int JiaoFangShiJian) {
            this.JiaoFangShiJian = JiaoFangShiJian;
        }

        public int getXuQiu() {
            return XuQiu;
        }

        public void setXuQiu(int XuQiu) {
            this.XuQiu = XuQiu;
        }

        public int getShuXing() {
            return ShuXing;
        }

        public void setShuXing(int ShuXing) {
            this.ShuXing = ShuXing;
        }

        public int getYuSuan() {
            return YuSuan;
        }

        public void setYuSuan(int YuSuan) {
            this.YuSuan = YuSuan;
        }

        public int getGongQi() {
            return GongQi;
        }

        public void setGongQi(int GongQi) {
            this.GongQi = GongQi;
        }

        public int getZhaoBiao() {
            return ZhaoBiao;
        }

        public void setZhaoBiao(int ZhaoBiao) {
            this.ZhaoBiao = ZhaoBiao;
        }

        public int getLiangFangDiZhi() {
            return LiangFangDiZhi;
        }

        public void setLiangFangDiZhi(int LiangFangDiZhi) {
            this.LiangFangDiZhi = LiangFangDiZhi;
        }

        public int getLiangFangShiJian() {
            return LiangFangShiJian;
        }

        public void setLiangFangShiJian(int LiangFangShiJian) {
            this.LiangFangShiJian = LiangFangShiJian;
        }

        public int getZhuangXiuShiJian() {
            return ZhuangXiuShiJian;
        }

        public void setZhuangXiuShiJian(int ZhuangXiuShiJian) {
            this.ZhuangXiuShiJian = ZhuangXiuShiJian;
        }

        public int getGuiMo() {
            return GuiMo;
        }

        public void setGuiMo(int GuiMo) {
            this.GuiMo = GuiMo;
        }

        public int getLouPan() {
            return LouPan;
        }

        public void setLouPan(int LouPan) {
            this.LouPan = LouPan;
        }

        public int getQiZuo() {
            return QiZuo;
        }

        public void setQiZuo(int QiZuo) {
            this.QiZuo = QiZuo;
        }

        public int getShouJi() {
            return ShouJi;
        }

        public void setShouJi(int ShouJi) {
            this.ShouJi = ShouJi;
        }
    }
}
