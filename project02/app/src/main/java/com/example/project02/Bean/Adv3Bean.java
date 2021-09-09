package com.example.project02.Bean;

import java.util.List;

public class Adv3Bean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1,"imgUrl":"/prod-api/profile/upload/image/2021/05/11/921ee654-d6c3-4876-8450-16ac272e18df.jpg","hospitalId":1},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":2,"imgUrl":"/prod-api/profile/upload/image/2021/05/11/4d41e85e-9099-4de6-b3c5-5e97123b1734.jpg","hospitalId":1},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":3,"imgUrl":"/prod-api/profile/upload/image/2021/05/11/32b46ab7-a004-4c81-abb5-4f6a87d1fd76.jpg","hospitalId":1}]
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
         * id : 1
         * imgUrl : /prod-api/profile/upload/image/2021/05/11/921ee654-d6c3-4876-8450-16ac272e18df.jpg
         * hospitalId : 1
         */

        public Object searchValue;
        public Object createBy;
        public Object createTime;
        public Object updateBy;
        public Object updateTime;
        public Object remark;
        public ParamsBean params;
        public int id;
        public String imgUrl;
        public int hospitalId;

        public static class ParamsBean {
        }
    }
}
