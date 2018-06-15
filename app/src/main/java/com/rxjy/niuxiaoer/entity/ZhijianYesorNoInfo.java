package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 */

public class ZhijianYesorNoInfo {


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"Name":"公司名称","XinXiJieGuo":"真实有效"}]
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
         * Name : 公司名称
         * XinXiJieGuo : 真实有效
         */

        private String Name;
        private String XinXiJieGuo;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getXinXiJieGuo() {
            return XinXiJieGuo;
        }

        public void setXinXiJieGuo(String XinXiJieGuo) {
            this.XinXiJieGuo = XinXiJieGuo;
        }
    }
}
