package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */

public class NewOneXiaLaInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"ID":0,"MingCheng":"请选择"},{"ID":1,"MingCheng":"办公"},{"ID":2,"MingCheng":"餐饮"},{"ID":3,"MingCheng":"商业"},{"ID":4,"MingCheng":"酒店"},{"ID":5,"MingCheng":"其他"}]
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
         * ID : 0
         * MingCheng : 请选择
         */

        private int ID;
        private String MingCheng;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getMingCheng() {
            return MingCheng;
        }

        public void setMingCheng(String MingCheng) {
            this.MingCheng = MingCheng;
        }
    }
}
