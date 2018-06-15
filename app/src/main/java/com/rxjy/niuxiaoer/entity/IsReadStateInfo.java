package com.rxjy.niuxiaoer.entity;

/**
 * Created by AAA on 2017/8/17.
 */

public class IsReadStateInfo {

    private int StatusCode;
    private String StatusMsg;
    private IsReadState Body;

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

    public IsReadState getBody() {
        return Body;
    }

    public void setBody(IsReadState Body) {
        this.Body = Body;
    }

    public static class IsReadState {

        private int status;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
