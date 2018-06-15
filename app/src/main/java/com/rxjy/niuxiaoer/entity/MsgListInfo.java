package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by AAA on 2017/9/18.
 */

public class MsgListInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<MsgList> Body;

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

    public List<MsgList> getBody() {
        return Body;
    }

    public void setBody(List<MsgList> Body) {
        this.Body = Body;
    }

    public static class MsgList {

        private int XinID;
        private int KeHuBaseID;
        private String Content;
        private String CreateTime;
        private int Status;
        private int LeiXing;
        private String Name;

        public int getXinID() {
            return XinID;
        }

        public void setXinID(int XinID) {
            this.XinID = XinID;
        }

        public int getKeHuBaseID() {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(int KeHuBaseID) {
            this.KeHuBaseID = KeHuBaseID;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public int getLeiXing() {
            return LeiXing;
        }

        public void setLeiXing(int LeiXing) {
            this.LeiXing = LeiXing;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }
    }
}
