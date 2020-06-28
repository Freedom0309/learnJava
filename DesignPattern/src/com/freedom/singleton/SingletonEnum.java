package com.freedom.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Describe: 枚举类型的单例
 * @version:
 * @author: liuf
 * @date: 2020-05-19
 */
public enum SingletonEnum {
    INSTANCE;
    public SingletonEnum getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonEnum instance = SingletonEnum.INSTANCE;

        Constructor<SingletonEnum> constructor = SingletonEnum.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        //.IllegalArgumentException: Cannot reflectively create enum objects
        SingletonEnum instance1 = constructor.newInstance();

        System.out.println(instance);
        System.out.println(instance1);

    }
}
