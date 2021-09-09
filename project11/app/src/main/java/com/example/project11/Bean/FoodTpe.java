package com.example.project11.Bean;

import java.util.List;

public class FoodTpe {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":"2021-05-08 15:30:07","updateBy":null,"updateTime":"2021-05-09 14:23:23","remark":null,"params":{},"id":3,"name":"披萨","sellerId":1,"themeId":5,"sort":1},{"searchValue":null,"createBy":null,"createTime":"2021-05-09 14:24:08","updateBy":null,"updateTime":"2021-05-09 14:25:17","remark":null,"params":{},"id":19,"name":"组合套餐","sellerId":1,"themeId":3,"sort":2},{"searchValue":null,"createBy":null,"createTime":"2021-05-09 14:24:23","updateBy":null,"updateTime":"2021-05-11 21:36:08","remark":null,"params":{},"id":20,"name":"焗饭","sellerId":1,"themeId":3,"sort":3}]
     */

    public String msg;
    public int code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2021-05-08 15:30:07
         * updateBy : null
         * updateTime : 2021-05-09 14:23:23
         * remark : null
         * params : {}
         * id : 3
         * name : 披萨
         * sellerId : 1
         * themeId : 5
         * sort : 1
         */

        public Object searchValue;
        public Object createBy;
        public String createTime;
        public Object updateBy;
        public String updateTime;
        public Object remark;
        public ParamsBean params;
        public int id;
        public String name;
        public int sellerId;
        public int themeId;
        public int sort;

        public static class ParamsBean {
        }
    }
}
