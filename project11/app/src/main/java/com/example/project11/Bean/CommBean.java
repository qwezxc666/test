package com.example.project11.Bean;

import java.util.List;

public class CommBean {

    /**
     * total : 3
     * rows : [{"id":2,"userId":101,"sellerId":1,"score":1,"content":"很好吃","likeNum":100,"sellerName":"八大碗","userName":"user01","nickName":"测试会员账号1","avatar":"","commentDate":"2021-04-18 00:00:00","replyContent":"谢谢你，欢迎下次光临","replyTime":"2021-04-19 00:00:00"}]
     * code : 200
     * msg : 查询成功
     */

    public int total;
    public int code;
    public String msg;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 2
         * userId : 101
         * sellerId : 1
         * score : 1
         * content : 很好吃
         * likeNum : 100
         * sellerName : 八大碗
         * userName : user01
         * nickName : 测试会员账号1
         * avatar :
         * commentDate : 2021-04-18 00:00:00
         * replyContent : 谢谢你，欢迎下次光临
         * replyTime : 2021-04-19 00:00:00
         */

        public int id;
        public int userId;
        public int sellerId;
        public int score;
        public String content;
        public int likeNum;
        public String sellerName;
        public String userName;
        public String nickName;
        public String avatar;
        public String commentDate;
        public String replyContent;
        public String replyTime;
    }
}
