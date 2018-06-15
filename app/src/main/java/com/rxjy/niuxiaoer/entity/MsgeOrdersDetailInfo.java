package com.rxjy.niuxiaoer.entity;

/**
 * Created by Administrator on 2017/6/30.
 * 订单详情
 *
 */
public class MsgeOrdersDetailInfo
{

    private int StatusCode;
    private String StatusMsg;
    private OrdersDetail Body;

    public int getStatusCode()
    {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode)
    {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg()
    {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg)
    {
        this.StatusMsg = StatusMsg;
    }

    public OrdersDetail getBody()
    {
        return Body;
    }

    public void setBody(OrdersDetail Body)
    {
        this.Body = Body;
    }

    public static class OrdersDetail
    {
        private String DanHao;
        private int KeHuBaseID;
        private String XingMing;
        private int XingBie;
        private String ShouJiHaoYi;
        private String ShouJiHaoEr;
        private String ShouJiHaoSan;
        private String GongSiMingCheng;
        private String BanGongDiDian;
        private String YouXiang;
        private int LeiXingYi;
        private int LeiXingEr;
        private String LeiXingYiName;
        private String LeiXingErName;
        private int FangYuan;
        private double MianJi;
        private String YuJiLiangFang;
        private String LiangFangDiZhi;
        private double ZhuangXiuYuSuan;
        private int MianZuQi;
        private int ChengJiaoLeiXing;
        private int XiangMuShuXing;
        private String ZuQiKaiShi;
        private String ZuQiJieShu;
        private String BeiZhu;
        private int YuJiZhuangXiu;
        private int Duration;
        private int Decoration_demand;
        private int ShenFenID;
        private int ZhuZhongDianID;

        public String getLeiXingYiName()
        {
            return LeiXingYiName;
        }

        public void setLeiXingYiName(String leiXingYiName)
        {
            LeiXingYiName = leiXingYiName;
        }

        public String getLeiXingErName()
        {
            return LeiXingErName;
        }

        public void setLeiXingErName(String leiXingErName)
        {
            LeiXingErName = leiXingErName;
        }

        public int getDuration()
        {
            return Duration;
        }

        public void setDuration(int duration)
        {
            Duration = duration;
        }

        public String getDanHao()
        {
            return DanHao;
        }

        public void setDanHao(String DanHao)
        {
            this.DanHao = DanHao;
        }

        public int getKeHuBaseID()
        {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(int KeHuBaseID)
        {
            this.KeHuBaseID = KeHuBaseID;
        }

        public String getXingMing()
        {
            return XingMing;
        }

        public void setXingMing(String XingMing)
        {
            this.XingMing = XingMing;
        }

        public int getXingBie()
        {
            return XingBie;
        }

        public void setXingBie(int XingBie)
        {
            this.XingBie = XingBie;
        }

        public String getShouJiHaoYi()
        {
            return ShouJiHaoYi;
        }

        public void setShouJiHaoYi(String ShouJiHaoYi)
        {
            this.ShouJiHaoYi = ShouJiHaoYi;
        }

        public String getShouJiHaoEr()
        {
            return ShouJiHaoEr;
        }

        public void setShouJiHaoEr(String ShouJiHaoEr)
        {
            this.ShouJiHaoEr = ShouJiHaoEr;
        }

        public String getShouJiHaoSan()
        {
            return ShouJiHaoSan;
        }

        public void setShouJiHaoSan(String ShouJiHaoSan)
        {
            this.ShouJiHaoSan = ShouJiHaoSan;
        }

        public String getGongSiMingCheng()
        {
            return GongSiMingCheng;
        }

        public void setGongSiMingCheng(String GongSiMingCheng)
        {
            this.GongSiMingCheng = GongSiMingCheng;
        }

        public String getBanGongDiDian()
        {
            return BanGongDiDian;
        }

        public void setBanGongDiDian(String BanGongDiDian)
        {
            this.BanGongDiDian = BanGongDiDian;
        }

        public String getYouXiang()
        {
            return YouXiang;
        }

        public void setYouXiang(String YouXiang)
        {
            this.YouXiang = YouXiang;
        }

        public int getLeiXingYi()
        {
            return LeiXingYi;
        }

        public void setLeiXingYi(int LeiXingYi)
        {
            this.LeiXingYi = LeiXingYi;
        }

        public int getLeiXingEr()
        {
            return LeiXingEr;
        }

        public void setLeiXingEr(int LeiXingEr)
        {
            this.LeiXingEr = LeiXingEr;
        }

        public int getFangYuan()
        {
            return FangYuan;
        }

        public void setFangYuan(int FangYuan)
        {
            this.FangYuan = FangYuan;
        }

        public double getMianJi()
        {
            return MianJi;
        }

        public void setMianJi(double MianJi)
        {
            this.MianJi = MianJi;
        }

        public String getYuJiLiangFang()
        {
            return YuJiLiangFang;
        }

        public void setYuJiLiangFang(String YuJiLiangFang)
        {
            this.YuJiLiangFang = YuJiLiangFang;
        }

        public String getLiangFangDiZhi()
        {
            return LiangFangDiZhi;
        }

        public void setLiangFangDiZhi(String LiangFangDiZhi)
        {
            this.LiangFangDiZhi = LiangFangDiZhi;
        }

        public double getZhuangXiuYuSuan()
        {
            return ZhuangXiuYuSuan;
        }

        public void setZhuangXiuYuSuan(double ZhuangXiuYuSuan)
        {
            this.ZhuangXiuYuSuan = ZhuangXiuYuSuan;
        }

        public int getMianZuQi()
        {
            return MianZuQi;
        }

        public void setMianZuQi(int MianZuQi)
        {
            this.MianZuQi = MianZuQi;
        }

        public int getChengJiaoLeiXing()
        {
            return ChengJiaoLeiXing;
        }

        public void setChengJiaoLeiXing(int ChengJiaoLeiXing)
        {
            this.ChengJiaoLeiXing = ChengJiaoLeiXing;
        }

        public int getXiangMuShuXing()
        {
            return XiangMuShuXing;
        }

        public void setXiangMuShuXing(int XiangMuShuXing)
        {
            this.XiangMuShuXing = XiangMuShuXing;
        }

        public String getZuQiKaiShi()
        {
            return ZuQiKaiShi;
        }

        public void setZuQiKaiShi(String ZuQiKaiShi)
        {
            this.ZuQiKaiShi = ZuQiKaiShi;
        }

        public String getZuQiJieShu()
        {
            return ZuQiJieShu;
        }

        public void setZuQiJieShu(String ZuQiJieShu)
        {
            this.ZuQiJieShu = ZuQiJieShu;
        }

        public String getBeiZhu()
        {
            return BeiZhu;
        }

        public void setBeiZhu(String BeiZhu)
        {
            this.BeiZhu = BeiZhu;
        }

        public int getYuJiZhuangXiu()
        {
            return YuJiZhuangXiu;
        }

        public void setYuJiZhuangXiu(int YuJiZhuangXiu)
        {
            this.YuJiZhuangXiu = YuJiZhuangXiu;
        }

        public int getDecoration_demand()
        {
            return Decoration_demand;
        }

        public void setDecoration_demand(int Decoration_demand)
        {
            this.Decoration_demand = Decoration_demand;
        }

        public int getShenFenID()
        {
            return ShenFenID;
        }

        public void setShenFenID(int ShenFenID)
        {
            this.ShenFenID = ShenFenID;
        }

        public int getZhuZhongDianID()
        {
            return ZhuZhongDianID;
        }

        public void setZhuZhongDianID(int ZhuZhongDianID)
        {
            this.ZhuZhongDianID = ZhuZhongDianID;
        }
    }
}
