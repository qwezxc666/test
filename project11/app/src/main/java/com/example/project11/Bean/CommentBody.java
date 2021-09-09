package com.example.project11.Bean;

public class CommentBody {

    /**
     * content : 真好吃，下次还来
     * orderNo : 2021051120444612594
     * score : 5
     */

    public String content;
    public String orderNo;
    public int score;

    public CommentBody(String content, String orderNo, int score) {
        this.content = content;
        this.orderNo = orderNo;
        this.score = score;
    }
}
