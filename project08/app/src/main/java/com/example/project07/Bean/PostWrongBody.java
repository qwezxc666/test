package com.example.project07.Bean;

public class PostWrongBody {

    /**
     * content : 停车场数量错误
     * name : 测试停车场
     * photo : http://localhost/pic/a.jpg
     * remark :
     * spotCount : 12
     */

    public String content;
    public String name;
    public String photo;
    public String remark;
    public int spotCount;

    public PostWrongBody(String content, String name, String photo, String remark, int spotCount) {
        this.content = content;
        this.name = name;
        this.photo = photo;
        this.remark = remark;
        this.spotCount = spotCount;
    }
}
