package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */

public class NerFourInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"ZhuangXiuXuQiu":0,"ZhuangXiuYuSuan":0,"GongQi":"","ZhaoBiao":0,"LiangFangDiZhi":"","YuJiLiangFang":null,"YuJiZhuangXiuShiJian":null,"PingGuPrice":0}]
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
         * ZhuangXiuXuQiu : 0
         * ZhuangXiuYuSuan : 0.0
         * GongQi :
         * ZhaoBiao : 0
         * LiangFangDiZhi :
         * YuJiLiangFang : null
         * YuJiZhuangXiuShiJian : null
         * PingGuPrice : 0.0
         */

        private int ZhuangXiuXuQiu;
        private double ZhuangXiuYuSuan;
        private String GongQi;
        private int ZhaoBiao;
        private String LiangFangDiZhi;
        private String YuJiLiangFang;
        private String YuJiZhuangXiuShiJian;
        private double PingGuPrice;

        public int getZhuangXiuXuQiu() {
            return ZhuangXiuXuQiu;
        }

        public void setZhuangXiuXuQiu(int ZhuangXiuXuQiu) {
            this.ZhuangXiuXuQiu = ZhuangXiuXuQiu;
        }

        public double getZhuangXiuYuSuan() {
            return ZhuangXiuYuSuan;
        }

        public void setZhuangXiuYuSuan(double ZhuangXiuYuSuan) {
            this.ZhuangXiuYuSuan = ZhuangXiuYuSuan;
        }

        public String getGongQi() {
            return GongQi;
        }

        public void setGongQi(String GongQi) {
            this.GongQi = GongQi;
        }

        public int getZhaoBiao() {
            return ZhaoBiao;
        }

        public void setZhaoBiao(int ZhaoBiao) {
            this.ZhaoBiao = ZhaoBiao;
        }

        public String getLiangFangDiZhi() {
            return LiangFangDiZhi;
        }

        public void setLiangFangDiZhi(String LiangFangDiZhi) {
            this.LiangFangDiZhi = LiangFangDiZhi;
        }

        public String getYuJiLiangFang() {
            return YuJiLiangFang;
        }

        public void setYuJiLiangFang(String YuJiLiangFang) {
            this.YuJiLiangFang = YuJiLiangFang;
        }

        public String getYuJiZhuangXiuShiJian() {
            return YuJiZhuangXiuShiJian;
        }

        public void setYuJiZhuangXiuShiJian(String YuJiZhuangXiuShiJian) {
            this.YuJiZhuangXiuShiJian = YuJiZhuangXiuShiJian;
        }

        public double getPingGuPrice() {
            return PingGuPrice;
        }

        public void setPingGuPrice(double PingGuPrice) {
            this.PingGuPrice = PingGuPrice;
        }
    }
}
