package com.example.project07.Bean;

public class ReResultBean {

    /**
     * code : 200
     * data : {"plateNo":"车牌号","tel":"联系电话"}
     * msg : 操作成功
     */

    public int code;
    public DataBean data;
    public String msg;

    public static class DataBean {
        /**
         * plateNo : 车牌号
         * tel : 联系电话
         */

        public String plateNo;
        public String tel;
    }
}
