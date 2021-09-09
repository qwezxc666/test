package com.example.project11.Bean;

public class RefundBody {

    /**
     * orderNo : 2021051121250557366
     * reason : 好意思，不想要了
     */

    public String orderNo;
    public String reason;

    public RefundBody(String orderNo, String reason) {
        this.orderNo = orderNo;
        this.reason = reason;
    }
}
