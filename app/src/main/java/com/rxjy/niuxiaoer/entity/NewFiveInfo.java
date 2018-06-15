package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */

public class NewFiveInfo {


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"QiYeGuiMoID":0,"BuildName":"","LouPanQiZuo":"","PingGuPrice":400,"MemberOrder":3}]
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
         * QiYeGuiMoID : 0
         * BuildName :
         * LouPanQiZuo :
         * PingGuPrice : 400.0
         * MemberOrder : 3
         */

        private int QiYeGuiMoID;
        private String BuildName;
        private String LouPanQiZuo;
        private double PingGuPrice;
        private int MemberOrder;

        public int getQiYeGuiMoID() {
            return QiYeGuiMoID;
        }

        public void setQiYeGuiMoID(int QiYeGuiMoID) {
            this.QiYeGuiMoID = QiYeGuiMoID;
        }

        public String getBuildName() {
            return BuildName;
        }

        public void setBuildName(String BuildName) {
            this.BuildName = BuildName;
        }

        public String getLouPanQiZuo() {
            return LouPanQiZuo;
        }

        public void setLouPanQiZuo(String LouPanQiZuo) {
            this.LouPanQiZuo = LouPanQiZuo;
        }

        public double getPingGuPrice() {
            return PingGuPrice;
        }

        public void setPingGuPrice(double PingGuPrice) {
            this.PingGuPrice = PingGuPrice;
        }

        public int getMemberOrder() {
            return MemberOrder;
        }

        public void setMemberOrder(int MemberOrder) {
            this.MemberOrder = MemberOrder;
        }
    }
}
