package com.example.project11.Bean;

public class AddAddress {

    /**
     * addressDetail : 大连理工大学教学楼A3-118
     * label : 学校
     * name : 王大卫
     * phone : 15898135276
     */

    public String addressDetail;
    public String label;
    public String name;
    public String phone;

    public AddAddress(String addressDetail, String label, String name, String phone) {
        this.addressDetail = addressDetail;
        this.label = label;
        this.name = name;
        this.phone = phone;
    }
}
