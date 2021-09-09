package com.example.project02.Bean;

public class UserInforBody {

    /**
     * email : lixl@163.com
     * idCard : 210882199807251656
     * nickName : 大卫王
     * phonenumber : 15898125461
     * sex : 0
     */

    public String idCard;
    public String nickName;
    public String phonenumber;
    public String sex;
    public String avatar;

    public UserInforBody(String idCard, String nickName, String phonenumber, String sex, String avatar) {
        this.idCard = idCard;
        this.nickName = nickName;
        this.phonenumber = phonenumber;
        this.sex = sex;
        this.avatar = avatar;
    }
}
