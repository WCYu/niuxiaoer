package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ProjectInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"XingMing":"薛猛","ShouJiHaoYi":"15516081915","ShouJiHaoEr":"0","AreaName":"R6","LeiXing":"毛坯房","MianJi":100,"PingGuPrice":5000}]
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
         * XingMing : 薛猛
         * ShouJiHaoYi : 15516081915
         * ShouJiHaoEr : 0
         * AreaName : R6
         * LeiXing : 毛坯房
         * MianJi : 100.0
         * PingGuPrice : 5000.0
         */

        private String XingMing;
        private String ShouJiHaoYi;
        private String ShouJiHaoEr;
        private String AreaName;
        private String LeiXing;
        private double MianJi;
        private double PingGuPrice;

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String XingMing) {
            this.XingMing = XingMing;
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

        public String getAreaName() {
            return AreaName;
        }

        public void setAreaName(String AreaName) {
            this.AreaName = AreaName;
        }

        public String getLeiXing() {
            return LeiXing;
        }

        public void setLeiXing(String LeiXing) {
            this.LeiXing = LeiXing;
        }

        public double getMianJi() {
            return MianJi;
        }

        public void setMianJi(double MianJi) {
            this.MianJi = MianJi;
        }

        public double getPingGuPrice() {
            return PingGuPrice;
        }

        public void setPingGuPrice(double PingGuPrice) {
            this.PingGuPrice = PingGuPrice;
        }
    }
}
