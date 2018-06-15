package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13.
 */

public class NewThreeInfo {

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"FangYuan":0,"MianJi":0,"ChengJiaoLeiXing":0,"MianZuQi":0,"JiaoFangShiJian":null,"YuJiZhuangXiu":0,"PingGuPrice":0}]
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
         * FangYuan : 0
         * MianJi : 0.0
         * ChengJiaoLeiXing : 0
         * MianZuQi : 0
         * JiaoFangShiJian : null
         * YuJiZhuangXiu : 0
         * PingGuPrice : 0.0
         */

        private int FangYuan;
        private double MianJi;
        private int ChengJiaoLeiXing;
        private int MianZuQi;
        private String JiaoFangShiJian;
        private int YuJiZhuangXiu;
        private double PingGuPrice;

        public int getFangYuan() {
            return FangYuan;
        }

        public void setFangYuan(int FangYuan) {
            this.FangYuan = FangYuan;
        }

        public double getMianJi() {
            return MianJi;
        }

        public void setMianJi(double MianJi) {
            this.MianJi = MianJi;
        }

        public int getChengJiaoLeiXing() {
            return ChengJiaoLeiXing;
        }

        public void setChengJiaoLeiXing(int ChengJiaoLeiXing) {
            this.ChengJiaoLeiXing = ChengJiaoLeiXing;
        }

        public int getMianZuQi() {
            return MianZuQi;
        }

        public void setMianZuQi(int MianZuQi) {
            this.MianZuQi = MianZuQi;
        }

        public String getJiaoFangShiJian() {
            return JiaoFangShiJian;
        }

        public void setJiaoFangShiJian(String JiaoFangShiJian) {
            this.JiaoFangShiJian = JiaoFangShiJian;
        }

        public int getYuJiZhuangXiu() {
            return YuJiZhuangXiu;
        }

        public void setYuJiZhuangXiu(int YuJiZhuangXiu) {
            this.YuJiZhuangXiu = YuJiZhuangXiu;
        }

        public double getPingGuPrice() {
            return PingGuPrice;
        }

        public void setPingGuPrice(double PingGuPrice) {
            this.PingGuPrice = PingGuPrice;
        }
    }
}
