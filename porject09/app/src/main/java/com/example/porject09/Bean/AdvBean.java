package com.example.porject09.Bean;

import java.util.List;

public class AdvBean {

    /**
     * total : 3
     * rows : [{"searchValue":null,"createBy":"admin","createTime":"2021-05-05 12:35:36","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":21,"appType":"traffic","status":"1","sort":1,"advTitle":"新闻","advImg":"/prod-api/profile/upload/image/2021/05/05/ff133289-6f6d-47c7-bf55-9bf6b43c1a48.jpeg","servModule":"news","targetId":null,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-05 12:35:58","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":22,"appType":"traffic","status":"1","sort":2,"advTitle":"新闻","advImg":"/prod-api/profile/upload/image/2021/05/05/0b83479e-72d9-4342-93e8-750fea1a053d.jpeg","servModule":"news","targetId":null,"type":"2"},{"searchValue":null,"createBy":"admin","createTime":"2021-05-05 12:45:44","updateBy":null,"updateTime":null,"remark":null,"params":{},"id":23,"appType":"traffic","status":"1","sort":3,"advTitle":"新闻","advImg":"/prod-api/profile/upload/image/2021/05/05/003adf91-6721-4854-a48e-95fe1cd496f6.jpeg","servModule":"news","targetId":null,"type":"2"}]
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
         * createTime : 2021-05-05 12:35:36
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 21
         * appType : traffic
         * status : 1
         * sort : 1
         * advTitle : 新闻
         * advImg : /prod-api/profile/upload/image/2021/05/05/ff133289-6f6d-47c7-bf55-9bf6b43c1a48.jpeg
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
