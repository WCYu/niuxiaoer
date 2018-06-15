package com.rxjy.niuxiaoer.entity;

/**
 * Created by Administrator on 2017/10/12.
 */

public class GetDanHaoInfo {


    /**
     * StatusCode : 0
     * StatusMsg : 成功
     * Body : {"DanHao":"11-181825"}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * DanHao : 11-181825
         */

        private String DanHao;

        public String getDanHao() {
            return DanHao;
        }

        public void setDanHao(String DanHao) {
            this.DanHao = DanHao;
        }
    }
}
