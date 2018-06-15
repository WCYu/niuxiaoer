package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12.
 */

public class NewTwoXiaLaInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"ID":0,"MingCheng":"请选择"},{"ID":129,"MingCheng":"20~30岁"},{"ID":130,"MingCheng":"30~40岁"},{"ID":131,"MingCheng":"40~50岁"},{"ID":132,"MingCheng":"50以上"}]
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
