package com.example.cse01.Bean;

public class UserInforBean {

    /**
     * msg : 操作成功
     * code : 200
     * user : {"userId":2,"userName":"test01","nickName":"测试用户01","email":"ljxl@qq.com","phonenumber":"13800000000","sex":"0","avatar":"","idCard":"210211199909090014","balance":9800,"score":10000}
     */

    public String msg;
    public int code;
    public UserBean user;

    public static class UserBean {
        /**
         * userId : 2
         * userName : test01
         * nickName : 测试用户01
         * email : ljxl@qq.com
         * phonenumber : 13800000000
         * sex : 0
         * avatar :
         * idCard : 210211199909090014
         * balance : 9800
         * score : 10000
         */

        public int userId;
        public String userName;
        public String nickName;
        public String email;
        public String phonenumber;
        public String sex;
        public String avatar;
        public String idCard;
        public int balance;
        public int score;
    }
}
