package com.example.project07.Bean;

import java.util.List;

public class AdbBean {


    /**
     * total : 3
     * rows : [{"searchValue":null,"createBy":"admin","createTime":"2021-05-05 12:32:21","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":18,"appType":"park","status":"1","sort":1,"advTitle":"新闻","advImg":"/prod-api/profile/upload/image/2021/05/05/73143911-6ae6-4423-aab5-545f619dc7ac.jpeg","servModule":"news","targetId":null,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-05 12:32:39","updateBy":"1","updateTime":"2021-05-05 12:50:19","remark":null,"params":{},"id":19,"appType":"park","status":"1","sort":2,"advTitle":"新闻","advImg":"/prod-api/profile/upload/image/2021/05/05/0eb91cd1-62e0-47ea-abdd-598adebc54de.jpeg","servModule":"news","targetId":null,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-05 12:33:00","updateBy":"1","updateTime":"2021-05-05 12:49:58","remark":null,"params":{},"id":20,"appType":"park","status":"1","sort":3,"advTitle":"新闻","advImg":"/prod-api/profile/upload/image/2021/05/05/4f2ce448-3051-4c9c-a1b8-d90bb6168fdb.jpeg","servModule":"news","targetId":null,"type":"2"}]
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
         * createTime : 2021-05-05 12:32:21
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 18
         * appType : park
         * status : 1
         * sort : 1
         * advTitle : 新闻
         * advImg : /prod-api/profile/upload/image/2021/05/05/73143911-6ae6-4423-aab5-545f619dc7ac.jpeg
         * servModule : news
         * targetId : null
         * type : 2
         */

        public Object searchValue;
        public String createBy;
        public String createTime;
        public Object updateBy;
        public Object updateTime;
        public Object remark;
        public ParamsBean params;
        public int id;
        public String appType;
        public String status;
        public int sort;
        public String advTitle;
        public String advImg;
        public String servModule;
        public Object targetId;
        public String type;

        public static class ParamsBean {
        }
    }
}
