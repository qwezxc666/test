package com.example.project07.Bean;

public class UserInforBean {

    /**
     * msg : 操作成功
     * code : 200
     * user : {"userId":1111122,"userName":"test01","nickName":"eee","email":"31232@qq.com","phonenumber":"23232312312","sex":"1","avatar":"/profile/upload/2021/05/23/516c160d-2bde-4a2e-8794-9a8bbe4e0fd9.jpg","idCard":"213232323231233231","balance":2300.4,"score":1000}
     */

    public String msg;
    public int code;
    public UserBean user;

    public static class UserBean {
        /**
         * userId : 1111122
         * userName : test01
         * nickName : eee
         * email : 31232@qq.com
         * phonenumber : 23232312312
         * sex : 1
         * avatar : /profile/upload/2021/05/23/516c160d-2bde-4a2e-8794-9a8bbe4e0fd9.jpg
         * idCard : 213232323231233231
         * balance : 2300.4
         * score : 1000
         */

        public int userId;
        public String userName;
        public String nickName;
        public String email;
        public String phonenumber;
        public String sex;
        public String avatar;
        public String idCard;
        public double balance;
        public int score;
    }
}
