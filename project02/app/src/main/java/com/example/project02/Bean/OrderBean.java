package com.example.project02.Bean;

import java.util.List;

public class OrderBean {

    /**
     * code : 200
     * msg : 查询成功
     * rows : [{"id":21,"orderNo":"2021051001061885228","amount":58,"orderStatus":"已付款","userId":2,"payTime":"2021-05-10","name":"中影华臣影城","orderType":"movie","orderTypeName":"看电影"}]
     * total : 1
     */

    public int code;
    public String msg;
    public int total;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 21
         * orderNo : 2021051001061885228
         * amount : 58
         * orderStatus : 已付款
         * userId : 2
         * payTime : 2021-05-10
         * name : 中影华臣影城
         * orderType : movie
         * orderTypeName : 看电影
         */

        public int id;
        public String orderNo;
        public int amount;
        public String orderStatus;
        public int userId;
        public String payTime;
        public String name;
        public String orderType;
        public String orderTypeName;
    }
}
