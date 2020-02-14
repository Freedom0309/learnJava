package com.freedom.visitor;

/**
 * @author liuf
 * date: 2020-02-13
 */
public class Client {
    public static void main(String[] args) {
        //创建ObjectStructure
        ObjectStructure structure = new ObjectStructure();

        structure.attach(new Man());
        structure.attach(new Man());
        structure.attach(new Man());
        structure.attach(new Woman());

        //成功
        Success success = new Success();
        structure.display(success);

        System.out.println("---------");
        structure.display(new Fail());
    }
}
