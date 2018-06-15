package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ZhijianbaogaoInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"NoXmCount":1,"YesXmCount":0,"PingGuPrice":800,"SureMoney":0}]
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
         * NoXmCount : 1
         * YesXmCount : 0
         * PingGuPrice : 800.0
         * SureMoney : 0.0
         */

        private int NoXmCount;
        private int YesXmCount;
        private double PingGuPrice;
        private double SureMoney;

        public int getNoXmCount() {
            return NoXmCount;
        }

        public void setNoXmCount(int NoXmCount) {
            this.NoXmCount = NoXmCount;
        }

        public int getYesXmCount() {
            return YesXmCount;
        }

        public void setYesXmCount(int YesXmCount) {
            this.YesXmCount = YesXmCount;
        }

        public double getPingGuPrice() {
            return PingGuPrice;
        }

        public void setPingGuPrice(double PingGuPrice) {
            this.PingGuPrice = PingGuPrice;
        }

        public double getSureMoney() {
            return SureMoney;
        }

        public void setSureMoney(double SureMoney) {
            this.SureMoney = SureMoney;
        }
    }
}
