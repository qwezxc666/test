package com.example.cse01.Bean;

import java.util.List;

public class SerBean {

    /**
     * code : 200
     * msg : 查询成功
     * rows : [{"id":17,"serviceName":"停车场","serviceDesc":"查询停车场","serviceType":"车主服务","imgUrl":"http://localhost:7777/profile/upload/image/2021/05/10/814fc6c4-de48-48a1-95f8-de3e749e348d.png","link":"park/index","sort":1,"isRecommend":"N"}]
     * total : 1
     */

    public int code;
    public String msg;
    public int total;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 17
         * serviceName : 停车场
         * serviceDesc : 查询停车场
         * serviceType : 车主服务
         * imgUrl : http://localhost:7777/profile/upload/image/2021/05/10/814fc6c4-de48-48a1-95f8-de3e749e348d.png
         * link : park/index
         * sort : 1
         * isRecommend : N
         */

        public int id;
        public String serviceName;
        public String serviceDesc;
        public String serviceType;
        public String imgUrl;
        public String link;
        public int sort;
        public String isRecommend;
    }
}
