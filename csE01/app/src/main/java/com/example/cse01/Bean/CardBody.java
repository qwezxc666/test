package com.example.cse01.Bean;

public class CardBody {

    /**
     * address : 大连市甘井子区
     * birthday : 2001-09-10
     * cardId : 210882199001302318
     * name : 张三
     * sex : 0
     * tel : 15800000000
     */

    public String address;
    public String birthday;
    public String cardId;
    public String name;
    public String sex;
    public String tel;

    public CardBody(String address, String birthday, String cardId, String name, String sex, String tel) {
        this.address = address;
        this.birthday = birthday;
        this.cardId = cardId;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
    }
}
