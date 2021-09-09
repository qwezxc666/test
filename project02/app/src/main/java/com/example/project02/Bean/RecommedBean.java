package com.example.project02.Bean;

import java.util.List;

public class RecommedBean {

    /**
     * total : 6
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2021-08-17 09:49:44","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":84,"userId":1111122,"activityId":1,"content":"我喜欢这个活动","commentTime":"2021-08-17 09:49:44","activityName":null,"userName":"test01","nickName":"Admin","avatar":"/profile/avatar/2021/08/28/6c1cfc8f-9803-46af-bdd4-150181f5627b.jpeg"},{"searchValue":null,"createBy":null,"createTime":"2021-07-28 17:31:44","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":51,"userId":1111122,"activityId":1,"content":"我喜欢这个活动","commentTime":"2021-07-28 17:31:44","activityName":null,"userName":"test01","nickName":"Admin","avatar":"/profile/avatar/2021/08/28/6c1cfc8f-9803-46af-bdd4-150181f5627b.jpeg"},{"searchValue":null,"createBy":null,"createTime":"2021-07-28 17:31:43","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":50,"userId":1111122,"activityId":1,"content":"我喜欢这个活动","commentTime":"2021-07-28 17:31:43","activityName":null,"userName":"test01","nickName":"Admin","avatar":"/profile/avatar/2021/08/28/6c1cfc8f-9803-46af-bdd4-150181f5627b.jpeg"},{"searchValue":null,"createBy":null,"createTime":"2021-07-28 17:19:28","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":49,"userId":1111122,"activityId":1,"content":"我喜欢这个活动","commentTime":"2021-07-28 17:19:28","activityName":null,"userName":"test01","nickName":"Admin","avatar":"/profile/avatar/2021/08/28/6c1cfc8f-9803-46af-bdd4-150181f5627b.jpeg"},{"searchValue":null,"createBy":null,"createTime":"2021-07-28 16:18:24","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":22,"userId":1111122,"activityId":1,"content":"我喜欢这个活动","commentTime":"2021-07-28 16:18:24","activityName":null,"userName":"test01","nickName":"Admin","avatar":"/profile/avatar/2021/08/28/6c1cfc8f-9803-46af-bdd4-150181f5627b.jpeg"},{"searchValue":null,"createBy":null,"createTime":"2021-07-26 15:36:20","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":5,"userId":1111172,"activityId":1,"content":"我喜欢这个活动","commentTime":"2021-07-26 15:36:20","activityName":null,"userName":"fsm","nickName":"fsmm","avatar":"/prod-api/profile/upload/image/2021/05/10/814fc6c4-de48-48a1-95f8-de3e749e348d.png"}]
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
         * createBy : null
         * createTime : 2021-08-17 09:49:44
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 84
         * userId : 1111122
         * activityId : 1
         * content : 我喜欢这个活动
         * commentTime : 2021-08-17 09:49:44
         * activityName : null
         * userName : test01
         * nickName : Admin
         * avatar : /profile/avatar/2021/08/28/6c1cfc8f-9803-46af-bdd4-150181f5627b.jpeg
         */

        public Object searchValue;
        public Object createBy;
        public String createTime;
        public Object updateBy;
        public Object updateTime;
        public Object remark;
        public ParamsBean params;
        public int id;
        public int userId;
        public int activityId;
        public String content;
        public String commentTime;
        public Object activityName;
        public String userName;
        public String nickName;
        public String avatar;

        public static class ParamsBean {
        }
    }
}
