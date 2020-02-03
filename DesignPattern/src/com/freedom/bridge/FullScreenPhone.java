package com.freedom.bridge;

public class FullScreenPhone extends Phone {
    public FullScreenPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        super.open();
        System.out.println("全面屏手机");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println("全面屏手机");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("全面屏手机");
    }
}
