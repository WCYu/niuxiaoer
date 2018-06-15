package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */

public class GetKehuXingmingInfo {


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"XingMing":""}]
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
         */

        private String XingMing;
        private String ShouJiHaoYi;

        public String getShouJiHaoYi() {
            return ShouJiHaoYi;
        }

        public void setShouJiHaoYi(String shouJiHaoYi) {
            ShouJiHaoYi = shouJiHaoYi;
        }

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String XingMing) {
            this.XingMing = XingMing;
        }
    }
}
