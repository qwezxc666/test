package com.example.project07.Bean;

import java.util.List;

public class ScoreListBean {

    /**
     * code :
     * msg :
     * rows : [{"id":2,"userId":1,"event":"绑定车辆","score":"10","changeDate":"2021-04-15 15:17:36","type":"获取"}]
     * total : 1
     */

    public String code;
    public String msg;
    public int total;
    public List<RowsBean> rows;

    public static class RowsBean {
        /**
         * id : 2
         * userId : 1
         * event : 绑定车辆
         * score : 10
         * changeDate : 2021-04-15 15:17:36
         * type : 获取
         */

        public int id;
        public int userId;
        public String event;
        public String score;
        public String changeDate;
        public String type;
    }
}
