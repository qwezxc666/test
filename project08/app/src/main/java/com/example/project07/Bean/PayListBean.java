package com.example.project07.Bean;

import java.util.List;

public class PayListBean {

    /**
     * code : 200
     * msg : 查询成功
     * rows : [{"id":4,"userId":2,"money":200,"rechargeDate":"2021-05-08 12:48:42","payType":"支付宝"}]
     * total : 1
     */

    public String code;
    public String msg;
    public String total;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 4
         * userId : 2
         * money : 200
         * rechargeDate : 2021-05-08 12:48:42
         * payType : 支付宝
         */

        public int id;
        public int userId;
        public int money;
        public String rechargeDate;
        public String payType;
    }
}
