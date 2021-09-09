package com.example.project11.Bean;

public class PersonBean {

    /**
     * msg : 操作成功
     * code : 200
     * user : {"userId":1111134,"userName":"zyjnb","nickName":"帅小伙","email":"@qq.com","phonenumber":"13454351311","sex":"0","avatar":"/prod-api/profile/upload/2021/07/14/ea359751-f33f-4862-84a5-bd6e18297bdf.jpg","idCard":"332222211241231241","balance":1000,"score":850}
     */

    public String msg;
    public int code;
    public UserBean user;

    public static class UserBean {
        /**
         * userId : 1111134
         * userName : zyjnb
         * nickName : 帅小伙
         * email : @qq.com
         * phonenumber : 13454351311
         * sex : 0
         * avatar : /prod-api/profile/upload/2021/07/14/ea359751-f33f-4862-84a5-bd6e18297bdf.jpg
         * idCard : 332222211241231241
         * balance : 1000.0
         * score : 850
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

