package com.freedom.observer;


/**
 * @author liuf
 * date: 2020-02-15
 */
public class ConcreteCondition implements Observer {
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Today, the temperature is " + temperature);
        System.out.println("Today, the pressure is " + pressure);
        System.out.println("Today, the humidity is " + humidity);
    }
}
