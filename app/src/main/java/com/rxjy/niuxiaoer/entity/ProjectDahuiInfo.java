package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ProjectDahuiInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"DaHuiYuanYin":"0.0","PingGuPrice":500}]
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
         * DaHuiYuanYin : 0.0
         * PingGuPrice : 500.0
         */

        private String DaHuiYuanYin;
        private double PingGuPrice;

        public String getDaHuiYuanYin() {
            return DaHuiYuanYin;
        }

        public void setDaHuiYuanYin(String DaHuiYuanYin) {
            this.DaHuiYuanYin = DaHuiYuanYin;
        }

        public double getPingGuPrice() {
            return PingGuPrice;
        }

        public void setPingGuPrice(double PingGuPrice) {
            this.PingGuPrice = PingGuPrice;
        }
    }
}
