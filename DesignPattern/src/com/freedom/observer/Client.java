package com.freedom.observer;

/**
 * @author liuf
 * date: 2020-02-15
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        //创建观察者
        ConcreteCondition concreteCondition = new ConcreteCondition();
        Baidu baidu = new Baidu();
        weatherData.registerObserver(concreteCondition);
        weatherData.registerObserver(baidu);

        //测试
        System.out.println("通知观察者：");
        weatherData.setData(10f, 20f, 30f);

        System.out.println(1 ^ 2 ^ 1);
        System.out.println(1 & 1);
    }
}
