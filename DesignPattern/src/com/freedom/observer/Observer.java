package com.freedom.observer;

/**
 * 观察者接口
 *
 * @author liuf
 * date: 2020-02-15
 */
public interface Observer {
    /**
     * 更新
     *
     * @param temperature 温度
     * @param pressure    气压
     * @param humidity    湿度
     */
    void update(float temperature, float pressure, float humidity);
}
