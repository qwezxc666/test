package com.example.project07.Bean;

public class WeaBean {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"maxTemperature":"12","uv":"弱","minTemperature":"24","temperature":"21","weather":"晴","humidity":"60","air":"无污染","apparentTemperature":"15","label":"今天","day":1}
     */

    public String msg;
    public int code;
    public DataBean data;

    public static class DataBean {
        /**
         * maxTemperature : 12
         * uv : 弱
         * minTemperature : 24
         * temperature : 21
         * weather : 晴
         * humidity : 60
         * air : 无污染
         * apparentTemperature : 15
         * label : 今天
         * day : 1
         */

        public String maxTemperature;
        public String uv;
        public String minTemperature;
        public String temperature;
        public String weather;
        public String humidity;
        public String air;
        public String apparentTemperature;
        public String label;
        public int day;
    }
}
