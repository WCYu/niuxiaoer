package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by AAA on 2017/9/18.
 */

public class ActivityListInfo {

    private int StatusCode;
    private String StatusMsg;
    private List<ActivityList> Body;

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

    public List<ActivityList> getBody() {
        return Body;
    }

    public void setBody(List<ActivityList> Body) {
        this.Body = Body;
    }

    public static class ActivityList {

        private int HuoDongID;
        private String Title;
        private String Content;
        private String CreateTime;
        private int Status;
        private int LeiXing;
        private String ImgUrl;
        private String BlankUrl;

        public int getHuoDongID() {
            return HuoDongID;
        }

        public void setHuoDongID(int HuoDongID) {
            this.HuoDongID = HuoDongID;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
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

        public String getImgUrl() {
            return ImgUrl;
        }

        public void setImgUrl(String ImgUrl) {
            this.ImgUrl = ImgUrl;
        }

        public String getBlankUrl() {
            return BlankUrl;
        }

        public void setBlankUrl(String BlankUrl) {
            this.BlankUrl = BlankUrl;
        }
    }
}
