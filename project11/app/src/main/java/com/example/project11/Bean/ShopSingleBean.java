package com.example.project11.Bean;

public class ShopSingleBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"id":1,"name":"尊宝比萨","address":"辽宁省大连市高新技术园区软景中心南门","introduction":"各种披萨","themeId":3,"score":4.9,"saleQuantity":379,"deliveryTime":30,"imgUrl":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/9e062202-b89d-412c-ae02-5370bb3b309b.jpg","avgCost":45,"other":null,"recommend":"N","distance":620,"saleNum3hour":21}
     */

    public String msg;
    public int code;
    public DataBean data;

    public static class DataBean {
        /**
         * id : 1
         * name : 尊宝比萨
         * address : 辽宁省大连市高新技术园区软景中心南门
         * introduction : 各种披萨
         * themeId : 3
         * score : 4.9
         * saleQuantity : 379
         * deliveryTime : 30
         * imgUrl : http://118.190.154.52:7777/profile/upload/image/2021/05/08/9e062202-b89d-412c-ae02-5370bb3b309b.jpg
         * avgCost : 45
         * other : null
         * recommend : N
         * distance : 620
         * saleNum3hour : 21
         */

        public int id;
        public String name;
        public String address;
        public String introduction;
        public int themeId;
        public double score;
        public int saleQuantity;
        public int deliveryTime;
        public String imgUrl;
        public int avgCost;
        public Object other;
        public String recommend;
        public int distance;
        public int saleNum3hour;
    }
}
