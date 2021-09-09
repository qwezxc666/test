package com.example.project02.Bean;

import java.util.List;

public class Adv2Bean {

    /**
     * total : 4
     * rows : [{"searchValue":null,"createBy":"admin","createTime":"2021-04-22 11:32:31","updateBy":"1","updateTime":"2021-05-08 14:07:45","remark":null,"params":{},"id":12,"appType":"activity","status":"1","sort":1,"advTitle":"活动广告1","advImg":"/prod-api/profile/upload/image/2021/05/08/a648fc9f-19de-4cb8-ab36-92784412d677.jpg","servModule":"活动管理","targetId":3,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-04-25 10:13:26","updateBy":"1","updateTime":"2021-05-08 14:09:10","remark":null,"params":{},"id":13,"appType":"activity","status":"1","sort":2,"advTitle":"活动广告2","advImg":"/prod-api/profile/upload/image/2021/05/08/3e8fea67-6175-4029-ac58-58f8285e592d.jpg","servModule":"活动管理","targetId":19,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-08 14:13:32","updateBy":"1","updateTime":"2021-05-14 13:49:11","remark":null,"params":{},"id":28,"appType":"activity","status":"1","sort":3,"advTitle":"活动广告3","advImg":"/prod-api/profile/upload/image/2021/05/08/daec8f1a-cfd5-426b-9118-dcc3ec3c72d3.jpg","servModule":"活动管理","targetId":26,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-08 14:14:35","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":29,"appType":"activity","status":"1","sort":4,"advTitle":"活动广告4","advImg":"/prod-api/profile/upload/image/2021/05/08/c4d8e1ad-abb7-4160-9bb5-e283024da32c.jpg","servModule":"活动管理","targetId":41,"type":"2"}]
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
         * createTime : 2021-04-22 11:32:31
         * updateBy : 1
         * updateTime : 2021-05-08 14:07:45
         * remark : null
         * params : {}
         * id : 12
         * appType : activity
         * status : 1
         * sort : 1
         * advTitle : 活动广告1
         * advImg : /prod-api/profile/upload/image/2021/05/08/a648fc9f-19de-4cb8-ab36-92784412d677.jpg
         * servModule : 活动管理
         * targetId : 3
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
