package com.freedom.decorator;

/**
 * @author liuf
 * date: 2020-02-03
 */
public abstract class Drink {
    public String des;
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 计算费用
     * @return cost 费用
     */
    public abstract float cost();
}
