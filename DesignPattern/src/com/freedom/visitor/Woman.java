package com.freedom.visitor;

/**
 * 1.这里我们使用到了双分派，即首先在客户端程序中，将具体状态作为参数传递Woman中（第一次分派）
 * 2.然后Woman类调用作为参数的具体方法中方法getWomanResult，同时将自己（this）作为参数传入，完成第二次分派
 * @author liuf
 * date: 2020-02-13
 */
public class Woman extends Person {
    @Override
    public void action(Action action) {
        action.getWomanResult(this);
    }
}
