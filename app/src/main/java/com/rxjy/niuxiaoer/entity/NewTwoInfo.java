package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */

public class NewTwoInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"XingMing":"","NianLingID":0,"ShenFenID":0,"WeiXin":"","ZhuZhongDianID":0,"PingGuPrice":0}]
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
         * XingMing :
         * NianLingID : 0
         * ShenFenID : 0
         * WeiXin :
         * ZhuZhongDianID : 0
         * PingGuPrice : 0.0
         */

        private String XingMing;
        private int NianLingID;
        private int ShenFenID;
        private String WeiXin;
        private int ZhuZhongDianID;
        private double PingGuPrice;

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String XingMing) {
            this.XingMing = XingMing;
        }

        public int getNianLingID() {
            return NianLingID;
        }

        public void setNianLingID(int NianLingID) {
            this.NianLingID = NianLingID;
        }

        public int getShenFenID() {
            return ShenFenID;
        }

        public void setShenFenID(int ShenFenID) {
            this.ShenFenID = ShenFenID;
        }

        public String getWeiXin() {
            return WeiXin;
        }

        public void setWeiXin(String WeiXin) {
            this.WeiXin = WeiXin;
        }

        public int getZhuZhongDianID() {
            return ZhuZhongDianID;
        }

        public void setZhuZhongDianID(int ZhuZhongDianID) {
            this.ZhuZhongDianID = ZhuZhongDianID;
        }

        public double getPingGuPrice() {
            return PingGuPrice;
        }

        public void setPingGuPrice(double PingGuPrice) {
            this.PingGuPrice = PingGuPrice;
        }
    }
}
