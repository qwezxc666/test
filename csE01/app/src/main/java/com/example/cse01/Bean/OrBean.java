package com.example.cse01.Bean;

import java.util.List;

public class OrBean {

    /**
     * total : 9
     * rows : [{"id":1,"orderNum":"60353861","path":"一号线","start":"泰德大厦","end":"大连北站","price":8,"userName":"张三","userTel":"12345611","userId":2,"status":0}]
     * code : 200
     * msg : 查询成功
     */

    public int total;
    public int code;
    public String msg;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 1
         * orderNum : 60353861
         * path : 一号线
         * start : 泰德大厦
         * end : 大连北站
         * price : 8
         * userName : 张三
         * userTel : 12345611
         * userId : 2
         * status : 0
         */

        public int id;
        public String orderNum;
        public String path;
        public String start;
        public String end;
        public int price;
        public String userName;
        public String userTel;
        public int userId;
        public int status;
    }
}
