package com.freedom.flyweight;

/**
 * @author liuf
 * date: 2020-02-07
 */
public class ConcreteWebSite extends WebSite {
    /**
     * 网站发布的形式
     */
    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("发布的形式为：" + type + "，使用者是：" + user.getName());
    }
}
