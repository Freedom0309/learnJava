package com.freedom.bridge;

public class Client {

    public static void main(String[] args) {
        Phone foldedPhone = new FoldedPhone(new XiaoMi());
        foldedPhone.open();
        foldedPhone.call();
        foldedPhone.close();

        Phone fullScreenPhone = new FullScreenPhone(new HuaWei());
        fullScreenPhone.open();
    }
}
