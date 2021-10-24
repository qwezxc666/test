package com.example.cse01.Bean;

import java.util.List;

public class AdvBean {

    /**
     * code : 200
     * msg : 查询成功
     * rows : [{"id":14,"sort":1,"advTitle":"测试首页轮播","advImg":"http://152.136.210.130:7777/profile/upload/image/2021/04/26/183e63c6-a59d-4551-a5b4-7055ff7a9575.jpg","servModule":"新闻","targetId":1,"type":"2"}]
     * total : 1
     */

    public String code;
    public String msg;
    public String total;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 14
         * sort : 1
         * advTitle : 测试首页轮播
         * advImg : http://152.136.210.130:7777/profile/upload/image/2021/04/26/183e63c6-a59d-4551-a5b4-7055ff7a9575.jpg
         * servModule : 新闻
         * targetId : 1
         * type : 2
         */

        public int id;
        public int sort;
        public String advTitle;
        public String advImg;
        public String servModule;
        public int targetId;
        public String type;
    }
}
