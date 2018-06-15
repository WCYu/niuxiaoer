package com.rxjy.niuxiaoer.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/31.
 */
public class GetClientMsgOne implements Serializable{
    private String StatusCode;
    private String StatusMsg;
    private Body Body;

    public GetClientMsgOne.Body getBody()
    {
        return Body;
    }

    public void setBody(GetClientMsgOne.Body body)
    {
        Body = body;
    }

    public String getStatusCode()
    {
        return StatusCode;
    }

    public void setStatusCode(String statusCode)
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





    public class Body implements Serializable
    {
        private String GongSiMingCheng;
        private String DanHao;
        private String TianJiaShiJian;
        private String State;
        private String StateName;

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
