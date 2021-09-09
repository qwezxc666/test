package com.example.project11.Bean;

import java.util.List;

public class AllColl {

    /**
     * total : 5
     * rows : [{"id":3,"userId":2,"sellerId":2,"sellerName":"皖北刘哥牛肉板面","address":"辽宁省大连市甘井子区新新园79号","imgUrl":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/30258b9d-3cea-44a8-9ce1-03c4790870d8.jpg","score":4.5,"saleQuantity":838,"userName":"test01","nickName":"测试用户01"}]
     * code : 200
     * msg : 查询成功
     */

    public int total;
    public int code;
    public String msg;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 3
         * userId : 2
         * sellerId : 2
         * sellerName : 皖北刘哥牛肉板面
         * address : 辽宁省大连市甘井子区新新园79号
         * imgUrl : http://118.190.154.52:7777/profile/upload/image/2021/05/08/30258b9d-3cea-44a8-9ce1-03c4790870d8.jpg
         * score : 4.5
         * saleQuantity : 838
         * userName : test01
         * nickName : 测试用户01
         */

        public int id;
        public int userId;
        public int sellerId;
        public String sellerName;
        public String address;
        public String imgUrl;
        public double score;
        public int saleQuantity;
        public String userName;
        public String nickName;
    }
}
