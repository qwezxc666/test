package com.example.cse01.Bean;

import java.util.List;

public class HosBanBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"id":1,"imgUrl":"http://118.190.154.52:7777/profile/upload/image/2021/05/11/921ee654-d6c3-4876-8450-16ac272e18df.jpg","hospitalId":1}]
     */

    public String msg;
    public int code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 1
         * imgUrl : http://118.190.154.52:7777/profile/upload/image/2021/05/11/921ee654-d6c3-4876-8450-16ac272e18df.jpg
         * hospitalId : 1
         */

        public int id;
        public String imgUrl;
        public int hospitalId;
    }
}
