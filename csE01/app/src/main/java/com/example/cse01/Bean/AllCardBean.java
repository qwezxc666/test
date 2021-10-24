package com.example.cse01.Bean;

import java.util.List;

public class AllCardBean {

    /**
     * total : 3
     * rows : [{"id":1,"name":"王大卫","cardId":"210211199909090014","tel":"13800000000","sex":"0","birthday":"1999-09-09","imgUrl":"/updata/1.jpg","address":"大连市高新区","userId":2}]
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
         * name : 王大卫
         * cardId : 210211199909090014
         * tel : 13800000000
         * sex : 0
         * birthday : 1999-09-09
         * imgUrl : /updata/1.jpg
         * address : 大连市高新区
         * userId : 2
         */

        public int id;
        public String name;
        public String cardId;
        public String tel;
        public String sex;
        public String birthday;
        public String imgUrl;
        public String address;
        public int userId;
    }
}
