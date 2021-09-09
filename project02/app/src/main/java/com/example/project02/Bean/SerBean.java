package com.example.project02.Bean;

import java.util.List;

public class SerBean {

    /**
     * total : 11
     * rows : [{"searchValue":null,"createBy":null,"createTime":"2020-10-23 16:17:56","updateBy":null,"updateTime":"2021-05-10 09:20:12","remark":null,"params":{},"id":17,"serviceName":"停哪儿","serviceDesc":"查询停车场","serviceType":"车主服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/814fc6c4-de48-48a1-95f8-de3e749e348d.png","pid":1,"link":"park/index","sort":0,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:23","updateBy":null,"updateTime":"2021-05-10 09:20:22","remark":null,"params":{},"id":2,"serviceName":"城市地铁","serviceDesc":"城市地铁路线","serviceType":"生活服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/3bfb33ee-459f-4878-b89b-4b125aa84013.png","pid":1,"link":"metro_query/index","sort":1,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:33","updateBy":null,"updateTime":"2021-05-10 09:20:33","remark":null,"params":{},"id":3,"serviceName":"智慧巴士","serviceDesc":"智慧巴士站点","serviceType":"便民服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/aa69f9d0-9718-42f9-9f79-c07b82a48c41.png","pid":1,"link":"bus_query/custom_shuttle","sort":2,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:17:58","updateBy":null,"updateTime":"2021-05-10 09:20:43","remark":null,"params":{},"id":5,"serviceName":"门诊预约","serviceDesc":"快捷方便不要出门也能门诊预约","serviceType":"便民服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/31a6533c-bf60-4890-9a25-b18db764776a.png","pid":1,"link":"outpatient/hospitalList","sort":3,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:18:39","updateBy":null,"updateTime":"2021-05-10 09:20:53","remark":null,"params":{},"id":9,"serviceName":"智慧交管","serviceDesc":"查询车辆违章","serviceType":"车主服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/426fdd6c-c2dd-4def-97eb-76c68c0103be.png","pid":1,"link":"traffic/index","sort":5,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2020-10-12 18:18:21","updateBy":null,"updateTime":"2021-05-10 09:21:03","remark":null,"params":{},"id":7,"serviceName":"生活缴费","serviceDesc":"不要出门也能缴费","serviceType":"生活服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/7abdfdc9-de48-4639-97a4-0cf2738a3073.png","pid":1,"link":"living_expenses/index","sort":6,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2021-05-05 11:41:35","updateBy":null,"updateTime":"2021-05-10 09:36:16","remark":null,"params":{},"id":19,"serviceName":"外卖订餐","serviceDesc":"外卖订餐","serviceType":"便民服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/22523c67-24a0-4825-9c1f-8cd19c7f0c24.png","pid":null,"link":"takeout/index","sort":7,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2021-05-05 11:42:31","updateBy":null,"updateTime":"2021-05-10 09:36:29","remark":null,"params":{},"id":20,"serviceName":"找房子","serviceDesc":"房屋租赁","serviceType":"便民服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/022a6703-cebf-4c47-9218-207e2874a030.png","pid":null,"link":"house/index","sort":8,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2021-05-05 11:41:05","updateBy":null,"updateTime":"2021-05-10 09:36:40","remark":null,"params":{},"id":18,"serviceName":"看电影","serviceDesc":"观影购票","serviceType":"生活服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/16ef12bf-d5eb-4df1-a896-bb08138f9fe6.png","pid":null,"link":"movie/index","sort":9,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2021-05-05 11:43:04","updateBy":null,"updateTime":"2021-05-10 09:36:48","remark":null,"params":{},"id":21,"serviceName":"找工作","serviceDesc":"招聘求职","serviceType":"便民服务","imgUrl":"/prod-api/profile/upload/image/2021/05/10/f9f9d0ac-3203-43fa-b4a7-2515192b0041.png","pid":null,"link":"job/index","sort":10,"isRecommend":"N"},{"searchValue":null,"createBy":null,"createTime":"2021-05-05 11:44:19","updateBy":null,"updateTime":"2021-05-12 10:45:49","remark":null,"params":{},"id":22,"serviceName":"活动管理","serviceDesc":"活动管理","serviceType":"生活服务","imgUrl":"/prod-api/profile/upload/image/2021/05/05/8f5d9d3a-3ac7-4e66-9d9a-630ba4bd80ef.png","pid":null,"link":"activity/index","sort":11,"isRecommend":"N"}]
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
         * createTime : 2020-10-23 16:17:56
         * updateBy : null
         * updateTime : 2021-05-10 09:20:12
         * remark : null
         * params : {}
         * id : 17
         * serviceName : 停哪儿
         * serviceDesc : 查询停车场
         * serviceType : 车主服务
         * imgUrl : /prod-api/profile/upload/image/2021/05/10/814fc6c4-de48-48a1-95f8-de3e749e348d.png
         * pid : 1
         * link : park/index
         * sort : 0
         * isRecommend : N
         */

        public Object searchValue;
        public Object createBy;
        public String createTime;
        public Object updateBy;
        public String updateTime;
        public Object remark;
        public ParamsBean params;
        public int id;
        public String serviceName;
        public String serviceDesc;
        public String serviceType;
        public String imgUrl;
        public int pid;
        public String link;
        public int sort;
        public String isRecommend;

        public static class ParamsBean {
        }
    }
}
