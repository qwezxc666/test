package com.example.project11.Bean;

import java.util.List;

public class AddressBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : [{"id":8,"userId":104,"name":"王大卫","phone":"15898135276","addressDetail":"大连理工大学 教学楼A3-118","label":"学校"}]
     */

    public String msg;
    public int code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 8
         * userId : 104
         * name : 王大卫
         * phone : 15898135276
         * addressDetail : 大连理工大学 教学楼A3-118
         * label : 学校
         */

        public int id;
        public int userId;
        public String name;
        public String phone;
        public String addressDetail;
        public String label;
    }
}
