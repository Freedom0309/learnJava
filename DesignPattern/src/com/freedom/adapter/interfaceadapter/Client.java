package com.freedom.adapter.interfaceadapter;

/**
 * 接口适配器模式，有选择的实现方法
 */
public class Client {
    public static void main(String[] args) {
        AbsAdapter adapter = new AbsAdapter() {
            @Override
            public void m1() {
                System.out.println("使用m1方法");
            }
        };
        adapter.m1();
    }
}
