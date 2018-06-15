package com.rxjy.niuxiaoer.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public class GetClientMsgList implements Serializable{
    private int StatusCode;
    private String StatusMsg;
    private List<Body> Body;



    public List<GetClientMsgList.Body> getBody()
    {
        return Body;
    }

    public void setBody(List<GetClientMsgList.Body> body)
    {
        Body = body;
    }

    public int getStatusCode()
    {
        return StatusCode;
    }

    public void setStatusCode(int statusCode)
    {
        StatusCode = statusCode;
    }

    public String getStatusMsg()
    {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg)
    {
        StatusMsg = statusMsg;
    }





    public class Body implements Serializable{
        private String GongSiMingCheng;
        private String DanHao;
        private String TianJiaShiJian;
        private String State;
        private int KeHuBaseID;
        private String StateName;
        private String XingMing;
        private int Status;

        public int getStatus() {
            return Status;
        }

        public void setStatus(int status) {
            Status = status;
        }

        public String getShouJiHaoYi() {
            return ShouJiHaoYi;
        }

        public void setShouJiHaoYi(String shouJiHaoYi) {
            ShouJiHaoYi = shouJiHaoYi;
        }

        private String ShouJiHaoYi;

        public String getXingMing() {
            return XingMing;
        }

        public void setXingMing(String xingMing) {
            XingMing = xingMing;
        }

        public int getKeHuBaseID() {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(int keHuBaseID) {
            KeHuBaseID = keHuBaseID;
        }


        public String getDanHao()
        {
            return DanHao;
        }

        public void setDanHao(String danHao)
        {
            DanHao = danHao;
        }

        public String getGongSiMingCheng()
        {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(String gongSiMingCheng)
        {
            GongSiMingCheng = gongSiMingCheng;
        }

        public String getState()
        {
            return State;
        }

        public void setState(String state)
        {
            State = state;
        }

        public String getTianJiaShiJian()
        {
            return TianJiaShiJian;
        }

        public void setTianJiaShiJian(String tianJiaShiJian)
        {
            TianJiaShiJian = tianJiaShiJian;
        }

        public String getStateName()
        {
            return StateName;
        }

        public void setStateName(String stateName)
        {
            StateName = stateName;
        }
    }

}
