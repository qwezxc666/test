package com.example.project07.Bean;

public class ReviseBody {

    /**
     * email : lixl@163.com
     * idCard : 210882199807251656
     * nickName : 大卫王
     * phonenumber : 15898125461
     * sex : 0
     */

    public String email;

    public ReviseBody(String email, String idCard, String nickName, String phonenumber, String sex, String avatar) {
        this.email = email;
        this.idCard = idCard;
        this.nickName = nickName;
        this.phonenumber = phonenumber;
        this.sex = sex;
        this.avatar = avatar;
    }

    public String idCard;
    public String nickName;
    public String phonenumber;
    public String sex;
    public String avatar;
}
