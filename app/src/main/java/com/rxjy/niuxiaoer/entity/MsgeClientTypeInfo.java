package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/7/4.
 */
public class MsgeClientTypeInfo
{

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : {"dt1":{"yiji":"办公","ziji":[{"ID":6,"MingCheng":"金融类"},{"ID":7,"MingCheng":"网络/科技"},{"ID":8,"MingCheng":"地产/开发"},{"ID":9,"MingCheng":"贸易类"},{"ID":11,"MingCheng":"文化/广告/传媒"},{"ID":12,"MingCheng":"教育培训"},{"ID":13,"MingCheng":"咨询/服务"},{"ID":14,"MingCheng":"政府/企事业"},{"ID":15,"MingCheng":"工业/生产/能源"},{"ID":16,"MingCheng":"医疗/生物/医药"},{"ID":18,"MingCheng":"孵化产业"},{"ID":79,"MingCheng":"早教机构"},{"ID":80,"MingCheng":"幼儿园"},{"ID":81,"MingCheng":"中小学机构"},{"ID":82,"MingCheng":"出国留学机构"}]},"dt2":{"yiji":"餐饮","ziji":[{"ID":19,"MingCheng":"中式餐厅"},{"ID":20,"MingCheng":"西式餐厅"},{"ID":21,"MingCheng":"快餐厅/连锁餐厅"},{"ID":22,"MingCheng":"主题餐厅"},{"ID":23,"MingCheng":"茶餐厅"},{"ID":24,"MingCheng":"火锅店"},{"ID":25,"MingCheng":"自助餐厅"},{"ID":26,"MingCheng":"特色烧烤/串吧"},{"ID":83,"MingCheng":"咖啡厅"},{"ID":84,"MingCheng":"日/韩/泰式餐厅"}]},"dt3":{"yiji":"商业","ziji":[{"ID":27,"MingCheng":"美容/美发/美甲店"},{"ID":28,"MingCheng":"商场/体验店/店面"},{"ID":29,"MingCheng":"茶楼/茶馆"},{"ID":31,"MingCheng":"网吧/网咖"},{"ID":32,"MingCheng":"休闲娱乐会所"},{"ID":85,"MingCheng":"展厅/展区"},{"ID":86,"MingCheng":"甜品/面包店"},{"ID":87,"MingCheng":"婚纱/摄影"},{"ID":88,"MingCheng":"售楼处"},{"ID":189,"MingCheng":"超市"},{"ID":190,"MingCheng":"主题会所"},{"ID":191,"MingCheng":"茶艺会所"},{"ID":192,"MingCheng":"高尔夫会所"}]},"dt4":{"yiji":"酒店","ziji":[{"ID":34,"MingCheng":"商务/精品酒店"},{"ID":37,"MingCheng":"主题酒店"},{"ID":38,"MingCheng":"连锁/快捷酒店"},{"ID":41,"MingCheng":"公寓"},{"ID":193,"MingCheng":"宾馆"},{"ID":194,"MingCheng":"旅店"},{"ID":195,"MingCheng":"度假酒店"},{"ID":196,"MingCheng":"温泉酒店"},{"ID":197,"MingCheng":"政府酒店"},{"ID":198,"MingCheng":"星级酒店"}]},"dt5":{"yiji":"其他","ziji":[{"ID":46,"MingCheng":"美容整形医院"},{"ID":47,"MingCheng":"商务/休闲/月子会所"},{"ID":49,"MingCheng":"健身馆/俱乐部/瑜伽馆"},{"ID":50,"MingCheng":"早教机构"},{"ID":89,"MingCheng":"足浴/养生会所"},{"ID":199,"MingCheng":"综合医院"},{"ID":200,"MingCheng":"专科医院"},{"ID":201,"MingCheng":"门诊"},{"ID":202,"MingCheng":"KTV"},{"ID":203,"MingCheng":"酒吧"},{"ID":204,"MingCheng":"网咖"},{"ID":205,"MingCheng":"棋牌室"},{"ID":206,"MingCheng":"游泳馆"},{"ID":207,"MingCheng":"夜店"},{"ID":208,"MingCheng":"图书馆"},{"ID":209,"MingCheng":"艺术培训"},{"ID":210,"MingCheng":"技能培训"},{"ID":211,"MingCheng":"大学"}]}}
     */

    private int StatusCode;
    private String StatusMsg;
    /**
     * dt1 : {"yiji":"办公","ziji":[{"ID":6,"MingCheng":"金融类"},{"ID":7,"MingCheng":"网络/科技"},{"ID":8,"MingCheng":"地产/开发"},{"ID":9,"MingCheng":"贸易类"},{"ID":11,"MingCheng":"文化/广告/传媒"},{"ID":12,"MingCheng":"教育培训"},{"ID":13,"MingCheng":"咨询/服务"},{"ID":14,"MingCheng":"政府/企事业"},{"ID":15,"MingCheng":"工业/生产/能源"},{"ID":16,"MingCheng":"医疗/生物/医药"},{"ID":18,"MingCheng":"孵化产业"},{"ID":79,"MingCheng":"早教机构"},{"ID":80,"MingCheng":"幼儿园"},{"ID":81,"MingCheng":"中小学机构"},{"ID":82,"MingCheng":"出国留学机构"}]}
     * dt2 : {"yiji":"餐饮","ziji":[{"ID":19,"MingCheng":"中式餐厅"},{"ID":20,"MingCheng":"西式餐厅"},{"ID":21,"MingCheng":"快餐厅/连锁餐厅"},{"ID":22,"MingCheng":"主题餐厅"},{"ID":23,"MingCheng":"茶餐厅"},{"ID":24,"MingCheng":"火锅店"},{"ID":25,"MingCheng":"自助餐厅"},{"ID":26,"MingCheng":"特色烧烤/串吧"},{"ID":83,"MingCheng":"咖啡厅"},{"ID":84,"MingCheng":"日/韩/泰式餐厅"}]}
     * dt3 : {"yiji":"商业","ziji":[{"ID":27,"MingCheng":"美容/美发/美甲店"},{"ID":28,"MingCheng":"商场/体验店/店面"},{"ID":29,"MingCheng":"茶楼/茶馆"},{"ID":31,"MingCheng":"网吧/网咖"},{"ID":32,"MingCheng":"休闲娱乐会所"},{"ID":85,"MingCheng":"展厅/展区"},{"ID":86,"MingCheng":"甜品/面包店"},{"ID":87,"MingCheng":"婚纱/摄影"},{"ID":88,"MingCheng":"售楼处"},{"ID":189,"MingCheng":"超市"},{"ID":190,"MingCheng":"主题会所"},{"ID":191,"MingCheng":"茶艺会所"},{"ID":192,"MingCheng":"高尔夫会所"}]}
     * dt4 : {"yiji":"酒店","ziji":[{"ID":34,"MingCheng":"商务/精品酒店"},{"ID":37,"MingCheng":"主题酒店"},{"ID":38,"MingCheng":"连锁/快捷酒店"},{"ID":41,"MingCheng":"公寓"},{"ID":193,"MingCheng":"宾馆"},{"ID":194,"MingCheng":"旅店"},{"ID":195,"MingCheng":"度假酒店"},{"ID":196,"MingCheng":"温泉酒店"},{"ID":197,"MingCheng":"政府酒店"},{"ID":198,"MingCheng":"星级酒店"}]}
     * dt5 : {"yiji":"其他","ziji":[{"ID":46,"MingCheng":"美容整形医院"},{"ID":47,"MingCheng":"商务/休闲/月子会所"},{"ID":49,"MingCheng":"健身馆/俱乐部/瑜伽馆"},{"ID":50,"MingCheng":"早教机构"},{"ID":89,"MingCheng":"足浴/养生会所"},{"ID":199,"MingCheng":"综合医院"},{"ID":200,"MingCheng":"专科医院"},{"ID":201,"MingCheng":"门诊"},{"ID":202,"MingCheng":"KTV"},{"ID":203,"MingCheng":"酒吧"},{"ID":204,"MingCheng":"网咖"},{"ID":205,"MingCheng":"棋牌室"},{"ID":206,"MingCheng":"游泳馆"},{"ID":207,"MingCheng":"夜店"},{"ID":208,"MingCheng":"图书馆"},{"ID":209,"MingCheng":"艺术培训"},{"ID":210,"MingCheng":"技能培训"},{"ID":211,"MingCheng":"大学"}]}
     */

    private ClientType Body;

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

    public ClientType getBody()
    {
        return Body;
    }

    public void setBody(ClientType Body)
    {
        this.Body = Body;
    }

    public static class ClientType
    {
        /**
         * yiji : 办公
         * ziji : [{"ID":6,"MingCheng":"金融类"},{"ID":7,"MingCheng":"网络/科技"},{"ID":8,"MingCheng":"地产/开发"},{"ID":9,"MingCheng":"贸易类"},{"ID":11,"MingCheng":"文化/广告/传媒"},{"ID":12,"MingCheng":"教育培训"},{"ID":13,"MingCheng":"咨询/服务"},{"ID":14,"MingCheng":"政府/企事业"},{"ID":15,"MingCheng":"工业/生产/能源"},{"ID":16,"MingCheng":"医疗/生物/医药"},{"ID":18,"MingCheng":"孵化产业"},{"ID":79,"MingCheng":"早教机构"},{"ID":80,"MingCheng":"幼儿园"},{"ID":81,"MingCheng":"中小学机构"},{"ID":82,"MingCheng":"出国留学机构"}]
         */

        private TypeOne dt1;
        /**
         * yiji : 餐饮
         * ziji : [{"ID":19,"MingCheng":"中式餐厅"},{"ID":20,"MingCheng":"西式餐厅"},{"ID":21,"MingCheng":"快餐厅/连锁餐厅"},{"ID":22,"MingCheng":"主题餐厅"},{"ID":23,"MingCheng":"茶餐厅"},{"ID":24,"MingCheng":"火锅店"},{"ID":25,"MingCheng":"自助餐厅"},{"ID":26,"MingCheng":"特色烧烤/串吧"},{"ID":83,"MingCheng":"咖啡厅"},{"ID":84,"MingCheng":"日/韩/泰式餐厅"}]
         */

        private TypeTwo dt2;
        /**
         * yiji : 商业
         * ziji : [{"ID":27,"MingCheng":"美容/美发/美甲店"},{"ID":28,"MingCheng":"商场/体验店/店面"},{"ID":29,"MingCheng":"茶楼/茶馆"},{"ID":31,"MingCheng":"网吧/网咖"},{"ID":32,"MingCheng":"休闲娱乐会所"},{"ID":85,"MingCheng":"展厅/展区"},{"ID":86,"MingCheng":"甜品/面包店"},{"ID":87,"MingCheng":"婚纱/摄影"},{"ID":88,"MingCheng":"售楼处"},{"ID":189,"MingCheng":"超市"},{"ID":190,"MingCheng":"主题会所"},{"ID":191,"MingCheng":"茶艺会所"},{"ID":192,"MingCheng":"高尔夫会所"}]
         */

        private TypeThree dt3;
        /**
         * yiji : 酒店
         * ziji : [{"ID":34,"MingCheng":"商务/精品酒店"},{"ID":37,"MingCheng":"主题酒店"},{"ID":38,"MingCheng":"连锁/快捷酒店"},{"ID":41,"MingCheng":"公寓"},{"ID":193,"MingCheng":"宾馆"},{"ID":194,"MingCheng":"旅店"},{"ID":195,"MingCheng":"度假酒店"},{"ID":196,"MingCheng":"温泉酒店"},{"ID":197,"MingCheng":"政府酒店"},{"ID":198,"MingCheng":"星级酒店"}]
         */

        private TypeFour dt4;
        /**
         * yiji : 其他
         * ziji : [{"ID":46,"MingCheng":"美容整形医院"},{"ID":47,"MingCheng":"商务/休闲/月子会所"},{"ID":49,"MingCheng":"健身馆/俱乐部/瑜伽馆"},{"ID":50,"MingCheng":"早教机构"},{"ID":89,"MingCheng":"足浴/养生会所"},{"ID":199,"MingCheng":"综合医院"},{"ID":200,"MingCheng":"专科医院"},{"ID":201,"MingCheng":"门诊"},{"ID":202,"MingCheng":"KTV"},{"ID":203,"MingCheng":"酒吧"},{"ID":204,"MingCheng":"网咖"},{"ID":205,"MingCheng":"棋牌室"},{"ID":206,"MingCheng":"游泳馆"},{"ID":207,"MingCheng":"夜店"},{"ID":208,"MingCheng":"图书馆"},{"ID":209,"MingCheng":"艺术培训"},{"ID":210,"MingCheng":"技能培训"},{"ID":211,"MingCheng":"大学"}]
         */

        private TypeFive dt5;

        public TypeOne getDt1()
        {
            return dt1;
        }

        public void setDt1(TypeOne dt1)
        {
            this.dt1 = dt1;
        }

        public TypeTwo getDt2()
        {
            return dt2;
        }

        public void setDt2(TypeTwo dt2)
        {
            this.dt2 = dt2;
        }

        public TypeThree getDt3()
        {
            return dt3;
        }

        public void setDt3(TypeThree dt3)
        {
            this.dt3 = dt3;
        }

        public TypeFour getDt4()
        {
            return dt4;
        }

        public void setDt4(TypeFour dt4)
        {
            this.dt4 = dt4;
        }

        public TypeFive getDt5()
        {
            return dt5;
        }

        public void setDt5(TypeFive dt5)
        {
            this.dt5 = dt5;
        }

        public static class TypeOne
        {
            private String yiji;
            /**
             * ID : 6
             * MingCheng : 金融类
             */

            private List<ChildClientType> ziji;
            private int ID;

            public int getID()
            {
                return ID;
            }

            public void setID(int ID)
            {
                this.ID = ID;
            }

            public String getYiji()
            {
                return yiji;
            }

            public void setYiji(String yiji)
            {
                this.yiji = yiji;
            }

            public List<ChildClientType> getZiji()
            {
                return ziji;
            }

            public void setZiji(List<ChildClientType> ziji)
            {
                this.ziji = ziji;
            }

            public static class ChildClientType
            {
                private int ID;
                private String MingCheng;

                public int getID()
                {
                    return ID;
                }

                public void setID(int ID)
                {
                    this.ID = ID;
                }

                public String getMingCheng()
                {
                    return MingCheng;
                }

                public void setMingCheng(String MingCheng)
                {
                    this.MingCheng = MingCheng;
                }
            }
        }

        public static class TypeTwo
        {
            private String yiji;
            /**
             * ID : 19
             * MingCheng : 中式餐厅
             */

            private List<ChildClientType> ziji;
            private int ID;

            public int getID()
            {
                return ID;
            }

            public void setID(int ID)
            {
                this.ID = ID;
            }

            public String getYiji()
            {
                return yiji;
            }

            public void setYiji(String yiji)
            {
                this.yiji = yiji;
            }

            public List<ChildClientType> getZiji()
            {
                return ziji;
            }

            public void setZiji(List<ChildClientType> ziji)
            {
                this.ziji = ziji;
            }

            public static class ChildClientType
            {
                private int ID;
                private String MingCheng;

                public int getID()
                {
                    return ID;
                }

                public void setID(int ID)
                {
                    this.ID = ID;
                }

                public String getMingCheng()
                {
                    return MingCheng;
                }

                public void setMingCheng(String MingCheng)
                {
                    this.MingCheng = MingCheng;
                }
            }
        }

        public static class TypeThree
        {
            private String yiji;
            /**
             * ID : 27
             * MingCheng : 美容/美发/美甲店
             */

            private List<ChildClientType> ziji;
            private int ID;

            public int getID()
            {
                return ID;
            }

            public void setID(int ID)
            {
                this.ID = ID;
            }

            public String getYiji()
            {
                return yiji;
            }

            public void setYiji(String yiji)
            {
                this.yiji = yiji;
            }

            public List<ChildClientType> getZiji()
            {
                return ziji;
            }

            public void setZiji(List<ChildClientType> ziji)
            {
                this.ziji = ziji;
            }

            public static class ChildClientType
            {
                private int ID;
                private String MingCheng;

                public int getID()
                {
                    return ID;
                }

                public void setID(int ID)
                {
                    this.ID = ID;
                }

                public String getMingCheng()
                {
                    return MingCheng;
                }

                public void setMingCheng(String MingCheng)
                {
                    this.MingCheng = MingCheng;
                }
            }
        }

        public static class TypeFour
        {
            private String yiji;
            /**
             * ID : 34
             * MingCheng : 商务/精品酒店
             */

            private List<ChildClientType> ziji;
            private int ID;

            public int getID()
            {
                return ID;
            }

            public void setID(int ID)
            {
                this.ID = ID;
            }

            public String getYiji()
            {
                return yiji;
            }

            public void setYiji(String yiji)
            {
                this.yiji = yiji;
            }

            public List<ChildClientType> getZiji()
            {
                return ziji;
            }

            public void setZiji(List<ChildClientType> ziji)
            {
                this.ziji = ziji;
            }

            public static class ChildClientType
            {
                private int ID;
                private String MingCheng;

                public int getID()
                {
                    return ID;
                }

                public void setID(int ID)
                {
                    this.ID = ID;
                }

                public String getMingCheng()
                {
                    return MingCheng;
                }

                public void setMingCheng(String MingCheng)
                {
                    this.MingCheng = MingCheng;
                }
            }
        }

        public static class TypeFive
        {
            private String yiji;
            /**
             * ID : 46
             * MingCheng : 美容整形医院
             */

            private List<ChildClientType> ziji;
            private int ID;

            public int getID()
            {
                return ID;
            }

            public void setID(int ID)
            {
                this.ID = ID;
            }

            public String getYiji()
            {
                return yiji;
            }

            public void setYiji(String yiji)
            {
                this.yiji = yiji;
            }

            public List<ChildClientType> getZiji()
            {
                return ziji;
            }

            public void setZiji(List<ChildClientType> ziji)
            {
                this.ziji = ziji;
            }

            public static class ChildClientType
            {
                private int ID;
                private String MingCheng;

                public int getID()
                {
                    return ID;
                }

                public void setID(int ID)
                {
                    this.ID = ID;
                }

                public String getMingCheng()
                {
                    return MingCheng;
                }

                public void setMingCheng(String MingCheng)
                {
                    this.MingCheng = MingCheng;
                }
            }
        }
    }
}
