package com.example.cse01.Bean;

import java.util.List;

public class BusBean {


    /**
     * total : 4
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2020-10-05 11:23:32","updateBy":null,"updateTime":"2020-10-21 11:23:35","remark":null,"params":{},"id":1,"name":"一号线","first":"光谷金融街","end":"南湖大厦","startTime":"6:30","endTime":"19:45","price":8,"mileage":"20"},{"searchValue":null,"createBy":null,"createTime":"2020-10-13 12:28:57","updateBy":null,"updateTime":"2020-10-22 12:29:00","remark":null,"params":{},"id":2,"name":"二号线","first":"光谷金融街","end":"万达广场","startTime":"6:30","endTime":"21:45","price":8,"mileage":"22"},{"searchValue":null,"createBy":null,"createTime":"2020-10-27 16:57:07","updateBy":null,"updateTime":"2020-10-27 16:57:21","remark":null,"params":{},"id":3,"name":"三号线","first":"香炉礁","end":"金石沙滩","startTime":"6:30","endTime":"22:00","price":9,"mileage":"30"},{"searchValue":null,"createBy":null,"createTime":"2020-10-27 16:59:03","updateBy":null,"updateTime":"2020-10-27 16:59:06","remark":null,"params":{},"id":4,"name":"十二号线","first":"河口","end":"辛寨子","startTime":"5:30","endTime":"23:00","price":12,"mileage":"40"}]
     * code : 200
     * msg : 查询成功
     */

    public int total;
    public int code;
    public String msg;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2020-10-05 11:23:32
         * updateBy : null
         * updateTime : 2020-10-21 11:23:35
         * remark : null
         * params : {}
         * id : 1
         * name : 一号线
         * first : 光谷金融街
         * end : 南湖大厦
         * startTime : 6:30
         * endTime : 19:45
         * price : 8.0
         * mileage : 20
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
        public String first;
        public String end;
        public String startTime;
        public String endTime;
        public double price;
        public String mileage;

        public static class ParamsBean {
        }
    }
}
