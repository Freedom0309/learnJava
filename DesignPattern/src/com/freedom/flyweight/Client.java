package com.freedom.flyweight;

/**
 * @author liuf
 * date: 2020-02-07
 */
public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();
        WebSite blog = factory.getWebSiteCategory("博客");
        blog.use(new User("新浪"));
        WebSite blog1 = factory.getWebSiteCategory("博客");
        blog1.use(new User("CSDN"));
        WebSite weibo = factory.getWebSiteCategory("微博");
        weibo.use(new User("新浪"));

        System.out.println("网站形式的数量为：" + factory.getWebSiteCount());
    }
}
