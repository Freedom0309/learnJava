package com.freedom.observer;

import java.util.ArrayList;

/**
 * 包含最新的天气情况
 * 含有观察者集合，使用ArrayList管理
 * 当数据变化时，调用ArrayList更新数据
 *
 * @author liuf
 * date: 2020-02-15
 */
public class WeatherData implements Subject {
    private float temperature;
    private float pressure;
    private float humidity;

    /**
     * 观察者集合
     */
    private ArrayList<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void changeData() {
        notifyObserver();
    }

    /**
     * 设置数据
     *
     * @param temperature
     * @param pressure
     * @param humidity
     */
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        changeData();
    }

    /**
     * 注册观察者
     *
     * @param o 观察者
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * 移除观察者
     *
     * @param o 观察者
     */
    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    /**
     * 通知观察者，数据改变
     */
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this.temperature, this.pressure, this.humidity);
        }
    }
}
