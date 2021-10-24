package com.example.cse01.Bean;

public class OrderBody {

    /**
     * start : 泰德大厦
     * end : 大连北站
     * price : 8
     * path : 一号线
     * status : 1
     */

    public String start;
    public String end;
    public String price;
    public String path;
    public int status;

    public OrderBody(String start, String end, String price, String path, int status) {
        this.start = start;
        this.end = end;
        this.price = price;
        this.path = path;
        this.status = status;
    }
}
