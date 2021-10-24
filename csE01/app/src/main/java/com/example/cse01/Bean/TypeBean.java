package com.example.cse01.Bean;

import java.util.List;

public class TypeBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"appType":"smart_city","name":"今日要闻","sort":1,"status":"Y","parentId":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":17,"appType":"smart_city","name":"专题聚焦","sort":5,"status":"Y","parentId":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":19,"appType":"smart_city","name":"政策解读","sort":7,"status":"Y","parentId":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":20,"appType":"smart_city","name":"经济发展","sort":8,"status":"Y","parentId":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":21,"appType":"smart_city","name":"文化旅游","sort":9,"status":"Y","parentId":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":22,"appType":"smart_city","name":"科技创新","sort":10,"status":"Y","parentId":null}]
     */

    public String msg;
    public int code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 9
         * appType : smart_city
         * name : 今日要闻
         * sort : 1
         * status : Y
         * parentId : null
         */

        public Object searchValue;
        public Object createBy;
        public Object createTime;
        public Object updateBy;
        public Object updateTime;
        public Object remark;
        public ParamsBean params;
        public int id;
        public String appType;
        public String name;
        public int sort;
        public String status;
        public Object parentId;

        public static class ParamsBean {
        }
    }
}
