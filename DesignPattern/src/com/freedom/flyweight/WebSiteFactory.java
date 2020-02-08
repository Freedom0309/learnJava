package com.freedom.flyweight;

import java.util.HashMap;

/**
 * 网站工厂类，返回一个具体的网站
 *
 * @author liuf
 * date: 2020-02-07
 */
public class WebSiteFactory {

    private HashMap<String, ConcreteWebSite> pool;

    /**
     * 根据网站的类型，返回一个网站，如果没有就创建一个网站，并放入到池中，并返回
     *
     * @param type 网站类型
     * @return 返回网站的实例
     */
    public WebSite getWebSiteCategory(String type) {
        //延迟创建
        if (pool == null) {
            pool = new HashMap<>();
        }
        if (!pool.containsKey(type)) {
            //创建一个网站，并放入到池中
            pool.put(type, new ConcreteWebSite(type));
        }
        return (WebSite) pool.get(type);
    }

    /**
     * 获取网站分类的总数
     *
     * @return 返回网站分类的总数
     */
    public int getWebSiteCount() {
        if (pool == null) {
            return 0;
        }
        return pool.size();
    }

}
