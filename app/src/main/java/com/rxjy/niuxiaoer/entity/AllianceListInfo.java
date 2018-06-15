package com.rxjy.niuxiaoer.entity;

import java.util.List;

/**
 * Created by AAA on 2017/8/17.
 */

public class AllianceListInfo {

    private int StatusCode;
    private String StatusMsg;
    private AllianceInfo Body;

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

    public AllianceInfo getBody() {
        return Body;
    }

    public void setBody(AllianceInfo Body) {
        this.Body = Body;
    }

    public static class AllianceInfo {

        private int count;
        private List<Alliance> table;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Alliance> getTable() {
            return table;
        }

        public void setTable(List<Alliance> table) {
            this.table = table;
        }

        public static class Alliance {
            /**
             * XingMing : 测试
             * image : 0001wKgBtFl-yICABECBAAD4Q-gHuvA7491179
             * YeWuYuanID : null
             * LiangCount : 0
             * YongjIN :
             * DayCount : 0
             */

            private String XingMing;
            private String image;
            private int LiangCount;
            private String YongjIN;
            private int DayCount;

            public String getXingMing() {
                return XingMing;
            }

            public void setXingMing(String XingMing) {
                this.XingMing = XingMing;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getLiangCount() {
                return LiangCount;
            }

            public void setLiangCount(int LiangCount) {
                this.LiangCount = LiangCount;
            }

            public String getYongjIN() {
                return YongjIN;
            }

            public void setYongjIN(String YongjIN) {
                this.YongjIN = YongjIN;
            }

            public int getDayCount() {
                return DayCount;
            }

            public void setDayCount(int DayCount) {
                this.DayCount = DayCount;
            }
        }
    }
}
