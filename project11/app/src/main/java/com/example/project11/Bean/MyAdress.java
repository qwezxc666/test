package com.example.project11.Bean;

public class MyAdress {

    /**
     * id : 8
     * name : 王大卫
     * phone : 15898135276
     * addressDetail : 大连理工大学 教学楼A2-118
     * label : 学校
     */

    public int id;
    public String name;
    public String phone;
    public String addressDetail;
    public String label;

    public MyAdress(int id, String name, String phone, String addressDetail, String label) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.addressDetail = addressDetail;
        this.label = label;
    }
}
