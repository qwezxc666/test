package com.example.porject09.Bean;

import java.util.List;

public class AllCarBean {

    /**
     * code : 200
     * msg : 查询成功
     * rows : [{"id":2,"userId":2,"plateNo":"辽B12345","engineNo":"1212XS123113","type":"小型汽车"}]
     * total : 1
     */

    public int code;
    public String msg;
    public String total;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 2
         * userId : 2
         * plateNo : 辽B12345
         * engineNo : 1212XS123113
         * type : 小型汽车
         */

        public int id;
        public int userId;
        public String plateNo;
        public String engineNo;
        public String type;
    }
}
