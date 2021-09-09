package com.example.project11.Bean;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"sellerInfo":{"id":1,"name":"尊宝比萨","address":"辽宁省大连市高新技术园区软景中心南门","introduction":"各种披萨","themeId":3,"score":4.9,"saleQuantity":379,"deliveryTime":30,"imgUrl":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/9e062202-b89d-412c-ae02-5370bb3b309b.jpg","avgCost":45,"other":null,"recommend":"N","distance":620,"saleNum3hour":21},"orderInfo":{"id":15,"orderNo":"2021051120444612594","userId":2,"sellerId":1,"amount":64,"postage":null,"status":"待支付","paymentType":null,"payTime":null,"sendTime":null,"receiverName":"王先生","receiverPhone":"13800000000","receiverAddress":"大连理工大学 教学楼A3-118","receiverLabel":null,"houseNumber":null,"orderItemList":[{"id":11,"userId":2,"orderNo":"2021051120444612594","productId":1,"productName":"柚见初夏套餐","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/88bcec33-736a-4128-ab8a-12f65776b6bd.jpg","productPrice":12,"quantity":2,"totalPrice":24},{"id":12,"userId":2,"orderNo":"2021051120444612594","productId":30,"productName":"10寸人气爆款比萨","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/9aace014-d039-45a6-bf58-c5b27861b277.jpg","productPrice":40,"quantity":1,"totalPrice":40}]}}
     */

    public String msg;
    public int code;
    public DataBean data;

    public static class DataBean {
        /**
         * sellerInfo : {"id":1,"name":"尊宝比萨","address":"辽宁省大连市高新技术园区软景中心南门","introduction":"各种披萨","themeId":3,"score":4.9,"saleQuantity":379,"deliveryTime":30,"imgUrl":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/9e062202-b89d-412c-ae02-5370bb3b309b.jpg","avgCost":45,"other":null,"recommend":"N","distance":620,"saleNum3hour":21}
         * orderInfo : {"id":15,"orderNo":"2021051120444612594","userId":2,"sellerId":1,"amount":64,"postage":null,"status":"待支付","paymentType":null,"payTime":null,"sendTime":null,"receiverName":"王先生","receiverPhone":"13800000000","receiverAddress":"大连理工大学 教学楼A3-118","receiverLabel":null,"houseNumber":null,"orderItemList":[{"id":11,"userId":2,"orderNo":"2021051120444612594","productId":1,"productName":"柚见初夏套餐","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/88bcec33-736a-4128-ab8a-12f65776b6bd.jpg","productPrice":12,"quantity":2,"totalPrice":24},{"id":12,"userId":2,"orderNo":"2021051120444612594","productId":30,"productName":"10寸人气爆款比萨","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/9aace014-d039-45a6-bf58-c5b27861b277.jpg","productPrice":40,"quantity":1,"totalPrice":40}]}
         */

        public SellerInfoBean sellerInfo;
        public OrderInfoBean orderInfo;

        public static class SellerInfoBean {
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

        public static class OrderInfoBean {
            /**
             * id : 15
             * orderNo : 2021051120444612594
             * userId : 2
             * sellerId : 1
             * amount : 64
             * postage : null
             * status : 待支付
             * paymentType : null
             * payTime : null
             * sendTime : null
             * receiverName : 王先生
             * receiverPhone : 13800000000
             * receiverAddress : 大连理工大学 教学楼A3-118
             * receiverLabel : null
             * houseNumber : null
             * orderItemList : [{"id":11,"userId":2,"orderNo":"2021051120444612594","productId":1,"productName":"柚见初夏套餐","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/88bcec33-736a-4128-ab8a-12f65776b6bd.jpg","productPrice":12,"quantity":2,"totalPrice":24},{"id":12,"userId":2,"orderNo":"2021051120444612594","productId":30,"productName":"10寸人气爆款比萨","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/08/9aace014-d039-45a6-bf58-c5b27861b277.jpg","productPrice":40,"quantity":1,"totalPrice":40}]
             */

            public int id;
            public String orderNo;
            public int userId;
            public int sellerId;
            public BigDecimal amount;
            public Object postage;
            public String status;
            public Object paymentType;
            public Object payTime;
            public Object sendTime;
            public String receiverName;
            public String receiverPhone;
            public String receiverAddress;
            public Object receiverLabel;
            public Object houseNumber;
            public List<OrderItemListBean> orderItemList;

            public static class OrderItemListBean {
                /**
                 * id : 11
                 * userId : 2
                 * orderNo : 2021051120444612594
                 * productId : 1
                 * productName : 柚见初夏套餐
                 * productImage : http://118.190.154.52:7777/profile/upload/image/2021/05/08/88bcec33-736a-4128-ab8a-12f65776b6bd.jpg
                 * productPrice : 12
                 * quantity : 2
                 * totalPrice : 24
                 */

                public int id;
                public int userId;
                public String orderNo;
                public int productId;
                public String productName;
                public String productImage;
                public BigDecimal productPrice;
                public int quantity;
                public BigDecimal totalPrice;
            }
        }
    }
}
