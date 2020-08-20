package com.freedom.zebra;

import java.util.Date;

public class ZplTest {
    public static void main(String[] args) {

        LabelMessage message = new LabelMessage();
        message.setCompany("陕西信合");
        message.setName("笔记本");
        message.setDepartment("科技部");
        message.setNumber("X000000007");
        message.setStartTime(new Date());
        message.setOwnerName("洛洛");
        message.setType("Lenovo");
        message.setAddress("1223");
        System.out.println(message.toString());
        ZplPrint zplPrint = new ZplPrint();
        zplPrint.execute(message);

    }
}
