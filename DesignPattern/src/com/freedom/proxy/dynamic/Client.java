package com.freedom.proxy.dynamic;

/**
 * @author liuf
 * date: 2020-02-08
 */
public class Client {
    public static void main(String[] args) {
        ITeacherDao target = new TeacherDao();

        ProxyFactory factory = new ProxyFactory(target);
        ITeacherDao proxyInstance = (ITeacherDao) factory.getProxyInstance();
        System.out.println("代理对象的类型：" + proxyInstance);
        System.out.println("代理对象的：" + proxyInstance.getClass());

    }
}
