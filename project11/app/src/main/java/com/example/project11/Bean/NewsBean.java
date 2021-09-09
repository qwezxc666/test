package com.example.project11.Bean;

import java.util.List;

public class NewsBean {

    /**
     * total : 3
     * rows : [{"searchValue":null,"createBy":"admin","createTime":"2021-05-06 15:40:17","updateBy":"1","updateTime":"2021-06-25 11:02:40","remark":null,"params":{},"id":25,"appType":"smart_city","status":"1","sort":2,"advTitle":"首页轮播","advImg":"/prod-api/profile/upload/image/2021/05/06/b9d9f081-8a76-41dc-8199-23bcb3a64fcc.png","servModule":"新闻详情","targetId":28,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-06 15:40:59","updateBy":"1111129","updateTime":"2021-06-25 11:02:51","remark":null,"params":{},"id":26,"appType":"smart_city","status":"1","sort":3,"advTitle":"首页轮播","advImg":"/prod-api/profile/upload/image/2021/05/06/e614cb7f-63b0-4cda-bf47-db286ea1b074.png","servModule":"新闻详情","targetId":29,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-06 15:41:20","updateBy":"1111129","updateTime":"2021-06-25 11:03:10","remark":null,"params":{},"id":27,"appType":"smart_city","status":"1","sort":4,"advTitle":"首页轮播","advImg":"/prod-api/profile/upload/image/2021/05/06/242e06f7-9fb0-4e16-b197-206f999c98f2.png","servModule":"新闻详情","targetId":30,"type":"2"}]
     * code : 200
     * msg : 查询成功
     */

    public int total;
    public int code;
    public String msg;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * searchValue : null
         * createBy : admin
         * createTime : 2021-05-06 15:40:17
         * updateBy : 1
         * updateTime : 2021-06-25 11:02:40
         * remark : null
         * params : {}
         * id : 25
         * appType : smart_city
         * status : 1
         * sort : 2
         * advTitle : 首页轮播
         * advImg : /prod-api/profile/upload/image/2021/05/06/b9d9f081-8a76-41dc-8199-23bcb3a64fcc.png
         * servModule : 新闻详情
         * targetId : 28
         * type : 2
         */

        public Object searchValue;
        public String createBy;
        public String createTime;
        public String updateBy;
        public String updateTime;
        public Object remark;
        public ParamsBean params;
        public int id;
        public String appType;
        public String status;
        public int sort;
        public String advTitle;
        public String advImg;
        public String servModule;
        public int targetId;
        public String type;

        public static class ParamsBean {
        }
    }
}
