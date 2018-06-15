package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */

public class NewOneInfo {


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"GongSiMingCheng":"","BanGongDiDian":"","LeiXingYi":0,"PingGuPrice":0}]
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
         * GongSiMingCheng :
         * BanGongDiDian :
         * LeiXingYi : 0
         * PingGuPrice : 0.0
         */

        private String GongSiMingCheng;
        private String BanGongDiDian;
        private String XingMing;
        private String Phone;
        private String SparePhone;
        private int LeiXingYi;
        private double PingGuPrice;

        public String getGongSiMingCheng() {
            return GongSiMingCheng;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String xingMing) {
            XingMing = xingMing;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String phone) {
            Phone = phone;
        }

        public String getSparePhone() {
            return SparePhone;
        }

        public void setSparePhone(String sparePhone) {
            SparePhone = sparePhone;
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

        public int getLeiXingYi() {
            return LeiXingYi;
        }

        public void setLeiXingYi(int LeiXingYi) {
            this.LeiXingYi = LeiXingYi;
        }

        public double getPingGuPrice() {
            return PingGuPrice;
        }

        public void setPingGuPrice(double PingGuPrice) {
            this.PingGuPrice = PingGuPrice;
        }
    }
}
