package com.freedom.template.improve;

/**
 * @author liuf
 * date: 2020-02-10
 */
public abstract class SoyMilk {
    /**
     * 模板方法，模板方法可以做成final，不让子类去覆盖
     */
    final void make() {
        select();
        if (customAddCondiments()) {
            addCondiments();
        }
        soak();
        beat();
    }

    void select() {
        System.out.println("选择材料");
    }

    /**
     * 添加不同的配料，抽象方法，子类实现
     */
    abstract void addCondiments();

    void soak() {
        System.out.println("浸泡原材料三个小时");
    }

    void beat() {
        System.out.println("打碎原材料");
    }

    boolean customAddCondiments() {
        return true;
    }
}
