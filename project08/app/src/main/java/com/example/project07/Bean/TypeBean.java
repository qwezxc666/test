package com.example.project07.Bean;

import java.util.List;

public class TypeBean {


    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"appType":"park","name":"国内新闻","sort":1,"status":"Y","parentId":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"appType":"park","name":"国际新闻","sort":2,"status":"Y","parentId":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"appType":"park","name":"娱乐新闻","sort":3,"status":"Y","parentId":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":24,"appType":"park","name":"体育新闻","sort":4,"status":"Y","parentId":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":25,"appType":"park","name":"财经新闻","sort":5,"status":"Y","parentId":null}]
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
         * id : 13
         * appType : park
         * name : 国内新闻
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
