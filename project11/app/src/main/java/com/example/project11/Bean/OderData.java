package com.example.project11.Bean;

import java.math.BigDecimal;
import java.util.List;

public class OderData {

    /**
     * total : 1
     * rows : [{"sellerInfo":{"id":14,"name":"九叶牛肉面","address":"沙河口区西南路29-1号","introduction":"用心做好面","themeId":5,"score":4.6,"saleQuantity":1635,"deliveryTime":42,"imgUrl":"http://118.190.154.52:7777/profile/upload/image/2021/05/09/b19808eb-8de1-4355-ace0-6cc801f00988.jpg","avgCost":30,"other":null,"recommend":"N","distance":3100,"saleNum3hour":25},"orderInfo":{"id":19,"orderNo":"2021051121282519510","userId":2,"sellerId":14,"amount":40,"postage":null,"status":"待支付","paymentType":null,"payTime":null,"sendTime":null,"receiverName":"王先生","receiverPhone":"13800000000","receiverAddress":"大连理工大学 教学楼A3-118","receiverLabel":null,"houseNumber":null,"orderItemList":[{"id":20,"userId":2,"orderNo":"2021051121282519510","productId":169,"productName":"鱿鱼炒面","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/09/c025e6a0-f91a-4965-835d-17ce2e7efe44.jpg","productPrice":20,"quantity":1,"totalPrice":20},{"id":21,"userId":2,"orderNo":"2021051121282519510","productId":170,"productName":"芸豆蚬子打卤面","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/09/882a3bb6-6893-4658-aead-6ace164d0da0.jpg","productPrice":20,"quantity":1,"totalPrice":20}]}}]
     * code : 200
     * msg : 查询成功
     */

    public int total;
    public int code;
    public String msg;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * sellerInfo : {"id":14,"name":"九叶牛肉面","address":"沙河口区西南路29-1号","introduction":"用心做好面","themeId":5,"score":4.6,"saleQuantity":1635,"deliveryTime":42,"imgUrl":"http://118.190.154.52:7777/profile/upload/image/2021/05/09/b19808eb-8de1-4355-ace0-6cc801f00988.jpg","avgCost":30,"other":null,"recommend":"N","distance":3100,"saleNum3hour":25}
         * orderInfo : {"id":19,"orderNo":"2021051121282519510","userId":2,"sellerId":14,"amount":40,"postage":null,"status":"待支付","paymentType":null,"payTime":null,"sendTime":null,"receiverName":"王先生","receiverPhone":"13800000000","receiverAddress":"大连理工大学 教学楼A3-118","receiverLabel":null,"houseNumber":null,"orderItemList":[{"id":20,"userId":2,"orderNo":"2021051121282519510","productId":169,"productName":"鱿鱼炒面","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/09/c025e6a0-f91a-4965-835d-17ce2e7efe44.jpg","productPrice":20,"quantity":1,"totalPrice":20},{"id":21,"userId":2,"orderNo":"2021051121282519510","productId":170,"productName":"芸豆蚬子打卤面","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/09/882a3bb6-6893-4658-aead-6ace164d0da0.jpg","productPrice":20,"quantity":1,"totalPrice":20}]}
         */

        public SellerInfoBean sellerInfo;
        public OrderInfoBean orderInfo;

        public static class SellerInfoBean {
            /**
             * id : 14
             * name : 九叶牛肉面
             * address : 沙河口区西南路29-1号
             * introduction : 用心做好面
             * themeId : 5
             * score : 4.6
             * saleQuantity : 1635
             * deliveryTime : 42
             * imgUrl : http://118.190.154.52:7777/profile/upload/image/2021/05/09/b19808eb-8de1-4355-ace0-6cc801f00988.jpg
             * avgCost : 30
             * other : null
             * recommend : N
             * distance : 3100
             * saleNum3hour : 25
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
             * id : 19
             * orderNo : 2021051121282519510
             * userId : 2
             * sellerId : 14
             * amount : 40
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
             * orderItemList : [{"id":20,"userId":2,"orderNo":"2021051121282519510","productId":169,"productName":"鱿鱼炒面","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/09/c025e6a0-f91a-4965-835d-17ce2e7efe44.jpg","productPrice":20,"quantity":1,"totalPrice":20},{"id":21,"userId":2,"orderNo":"2021051121282519510","productId":170,"productName":"芸豆蚬子打卤面","productImage":"http://118.190.154.52:7777/profile/upload/image/2021/05/09/882a3bb6-6893-4658-aead-6ace164d0da0.jpg","productPrice":20,"quantity":1,"totalPrice":20}]
             */

            public int id;
            public String orderNo;
            public String createTime;
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
                 * id : 20
                 * userId : 2
                 * orderNo : 2021051121282519510
                 * productId : 169
                 * productName : 鱿鱼炒面
                 * productImage : http://118.190.154.52:7777/profile/upload/image/2021/05/09/c025e6a0-f91a-4965-835d-17ce2e7efe44.jpg
                 * productPrice : 20
                 * quantity : 1
                 * totalPrice : 20
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
