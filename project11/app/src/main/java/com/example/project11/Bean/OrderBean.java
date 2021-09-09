package com.example.project11.Bean;

import java.util.List;

public class OrderBean {

    /**
     * addressDetail : 大连理工大学 教学楼A3-118
     * label : 学校
     * name : 王先生
     * phone : 13800000000
     * amount : 64
     * orderItemList : [{"productId":1,"quantity":2},{"productId":30,"quantity":1}]
     * sellerId : 1
     */

    public String addressDetail;
    public String label;
    public String name;
    public String phone;
    public int amount;
    public int sellerId;
    public List<OrderItemListBean> orderItemList;

    public static class OrderItemListBean {
        /**
         * productId : 1
         * quantity : 2
         */

        public int productId;
        public int quantity;
    }
}
