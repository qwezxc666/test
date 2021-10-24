package com.example.cse01.Bean;

import java.util.List;

public class LLBean {

    /**
     * code : 200
     * msg : 查询成功
     * rows : [{"id":1,"licencePlate":"辽B123456","disposeState":"已缴款","badTime":"2021-04-2011:51:17","money":"200","deductMarks":"6","illegalSites":"大连市万达广场","noticeNo":"2021042110040387379","engineNumber":"12345611","trafficOffence":"闯红灯","catType":"大型汽车","performOffice":"交警队","performDate":"2021-04-20","imgUrl":"/dev-api/profile/upload/image/2021/05/01/31fefb9a-a06b-47bd-bf71-8624e89b5044.jpg"}]
     * total : 1
     */

    public int code;
    public String msg;
    public int total;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 1
         * licencePlate : 辽B123456
         * disposeState : 已缴款
         * badTime : 2021-04-2011:51:17
         * money : 200
         * deductMarks : 6
         * illegalSites : 大连市万达广场
         * noticeNo : 2021042110040387379
         * engineNumber : 12345611
         * trafficOffence : 闯红灯
         * catType : 大型汽车
         * performOffice : 交警队
         * performDate : 2021-04-20
         * imgUrl : /dev-api/profile/upload/image/2021/05/01/31fefb9a-a06b-47bd-bf71-8624e89b5044.jpg
         */

        public int id;
        public String licencePlate;
        public String disposeState;
        public String badTime;
        public String money;
        public String deductMarks;
        public String illegalSites;
        public String noticeNo;
        public String engineNumber;
        public String trafficOffence;
        public String catType;
        public String performOffice;
        public String performDate;
        public String imgUrl;
    }
}
