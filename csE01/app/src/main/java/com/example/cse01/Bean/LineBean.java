package com.example.cse01.Bean;

import java.util.List;

public class LineBean {

    /**
     * total : 4
     * rows : [{"linesId":1,"stepsId":1,"name":"光谷金融街","sequence":1},{"linesId":1,"stepsId":2,"name":"解放路","sequence":2}]
     * code : 200
     * msg : 查询成功
     */

    public int total;
    public int code;
    public String msg;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * linesId : 1
         * stepsId : 1
         * name : 光谷金融街
         * sequence : 1
         */

        public int linesId;
        public int stepsId;
        public String name;
        public int sequence;
    }
}
