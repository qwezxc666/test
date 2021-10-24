package com.example.cse01.Bean;

public class NewsInforBean {

    /**
     * code : 200
     * data : {"id":5,"appType":"movie","cover":"/dev-api/profile/upload/image/2021/04/01/c1eb74b2-e964-4388-830a-1b606fc9699f.png","title":"驱蚊器无去","subTitle":"123123123","content":"<p>企鹅王请问<imgsrc=\"/dev-api/profile/upload/image/2021/04/07/a9434ccf-5acf-4bf5-a06e-c3457c6762e9.png\"><\/p>","status":"Y","publishDate":"2021-04-01","tags":null,"commentNum":null,"likeNum":3,"readNum":null,"type":"2","top":"Y","hot":"N"}
     * msg : 操作成功
     */

    public int code;
    public DataBean data;
    public String msg;

    public static class DataBean {
        /**
         * id : 5
         * appType : movie
         * cover : /dev-api/profile/upload/image/2021/04/01/c1eb74b2-e964-4388-830a-1b606fc9699f.png
         * title : 驱蚊器无去
         * subTitle : 123123123
         * content : <p>企鹅王请问<imgsrc="/dev-api/profile/upload/image/2021/04/07/a9434ccf-5acf-4bf5-a06e-c3457c6762e9.png"></p>
         * status : Y
         * publishDate : 2021-04-01
         * tags : null
         * commentNum : null
         * likeNum : 3
         * readNum : null
         * type : 2
         * top : Y
         * hot : N
         */

        public int id;
        public String appType;
        public String cover;
        public String title;
        public String subTitle;
        public String content;
        public String status;
        public String publishDate;
        public Object tags;
        public Object commentNum;
        public int likeNum;
        public Object readNum;
        public String type;
        public String top;
        public String hot;
    }
}
