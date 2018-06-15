package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */

public class FenGongSiInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"FenGongSiID":11,"GongSiMingCheng":"北京.R6"},{"FenGongSiID":12,"GongSiMingCheng":"北京.北京"},{"FenGongSiID":15,"GongSiMingCheng":"南京"},{"FenGongSiID":16,"GongSiMingCheng":"合肥"},{"FenGongSiID":18,"GongSiMingCheng":"武汉"},{"FenGongSiID":19,"GongSiMingCheng":"天津"},{"FenGongSiID":20,"GongSiMingCheng":"郑州"},{"FenGongSiID":21,"GongSiMingCheng":"重庆"},{"FenGongSiID":22,"GongSiMingCheng":"成都"},{"FenGongSiID":25,"GongSiMingCheng":"西安"},{"FenGongSiID":26,"GongSiMingCheng":"杭州"},{"FenGongSiID":30,"GongSiMingCheng":"济南"},{"FenGongSiID":31,"GongSiMingCheng":"石家庄"},{"FenGongSiID":36,"GongSiMingCheng":"宁波"},{"FenGongSiID":38,"GongSiMingCheng":"上海"},{"FenGongSiID":49,"GongSiMingCheng":"北京.望京"},{"FenGongSiID":50,"GongSiMingCheng":"北京.亦庄"},{"FenGongSiID":55,"GongSiMingCheng":"北京.双桥"},{"FenGongSiID":59,"GongSiMingCheng":"新锐"}]
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
         * FenGongSiID : 11
         * GongSiMingCheng : 北京.R6
         */

        private int FenGongSiID;
        private String GongSiMingCheng;

        public int getFenGongSiID() {
            return FenGongSiID;
        }

        public void setFenGongSiID(int FenGongSiID) {
            this.FenGongSiID = FenGongSiID;
        }

        public String getGongSiMingCheng() {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(String GongSiMingCheng) {
            this.GongSiMingCheng = GongSiMingCheng;
        }
    }
}
