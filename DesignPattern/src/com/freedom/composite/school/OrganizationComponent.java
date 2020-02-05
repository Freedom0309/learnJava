package com.freedom.composite.school;

/**
 * @author liuf
 * date: 2020-02-05
 */
public abstract class OrganizationComponent {

    private String name;
    /**
     * 描述
     */
    private String des;
    /**
     * 打印组件的内容，子组件实现
     */
    public abstract void print();

    public OrganizationComponent(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void addComponent(OrganizationComponent child){
        throw new UnsupportedOperationException("不支持此操作");
    }

    public void removeComponent(OrganizationComponent child){
        throw new UnsupportedOperationException("不支持此操作");
    }
}
