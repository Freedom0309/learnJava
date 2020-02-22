package com.freedom.responsibilitychain;

/**
 * @author liuf
 * date: 2020-02-22
 */
public class PurchaseRequest {
    private int type =0;
    private float price = 0.0f;
    private int id = 0;

    /**
     * 构造器
     * @param type
     * @param price
     * @param id
     */
    public PurchaseRequest(int type, float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
