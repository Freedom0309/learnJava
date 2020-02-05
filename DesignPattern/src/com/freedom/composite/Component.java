package com.freedom.composite;

/**
 * 抽象的组件对象，为组合中的对象声明接口，实现接口的缺省行为
 * @author liuf
 * date: 2020-02-05
 */
public abstract class Component {
    /**
     * 示意方法，子组件对象可能实现的方法
     */
    public abstract void printStruct(String preStr);

    /**
     * 向组合对象中加入组件对象
     * @param child 被加入到组合对象中的组件对象
     */
    public void addChild(Component child){
        //缺省的实现，抛出异常，因为叶子对象或者子组件没有实现这个功能
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 从组合对象中移除某个组件对象
     * @param child 被移除的组件对象
     */
    public void removeChild(Component child){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    /**
     * 返回某个索引对应的组件对象
     * @param index 需要获取的组件对象的索引，索引从0开始
     * @return 索引对应的组件对象
     */
    public Component getChild(int index){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

}
