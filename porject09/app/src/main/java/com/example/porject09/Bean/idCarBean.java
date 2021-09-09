package com.example.porject09.Bean;

import java.util.List;

public class idCarBean {


    /**
     * msg : 操作成功
     * code : 200
     * data : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":31,"userId":1111134,"licenseNo":"1232312312312","licenseLevel":null,"idCard":"1232312312312","score":12,"applyDate":null,"verifyDate":"2021年9月1日","timeout":"0","userName":null,"fileNo":null,"auditOffice":null,"contact":null}]
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
         * id : 31
         * userId : 1111134
         * licenseNo : 1232312312312
         * licenseLevel : null
         * idCard : 1232312312312
         * score : 12
         * applyDate : null
         * verifyDate : 2021年9月1日
         * timeout : 0
         * userName : null
         * fileNo : null
         * auditOffice : null
         * contact : null
         */

        public Object searchValue;
        public Object createBy;
        public Object createTime;
        public Object updateBy;
        public Object updateTime;
        public Object remark;
        public ParamsBean params;
        public int id;
        public int userId;
        public String licenseNo;
        public Object licenseLevel;
        public String idCard;
        public int score;
        public Object applyDate;
        public String verifyDate;
        public String timeout;
        public Object userName;
        public Object fileNo;
        public Object auditOffice;
        public Object contact;

        public static class ParamsBean {
        }
    }
}
