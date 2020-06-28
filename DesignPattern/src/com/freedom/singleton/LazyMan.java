package com.freedom.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Describe:
 * @version:
 * @author: liuf
 * @date: 2020-05-19
 */
public class LazyMan {
    private volatile static LazyMan lazyMan;

    private static boolean flag = false;
    private LazyMan() {
        synchronized(LazyMan.class){
            //3.使用标志位来防止反射获取对象
            if (flag == false){
                flag = true;
            }else {
                throw new RuntimeException("请不要使用反射来获取对象");
            }
        }
    }

    public static LazyMan getInstance() {
        //双重检测锁模式的单例 DCL
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }

        return lazyMan;
    }

    public static void main(String[] args) throws Exception, NoSuchMethodException {

        //4.获取标志位字段，来破环单例，使反射有效，需反编译获取标志位属性名
        Field field = LazyMan.class.getDeclaredField("flag");
        field.setAccessible(true);
        //---------------------------

        //1.使用反射来获取实例
        Constructor<LazyMan> declaredAnnotation = LazyMan.class.getDeclaredConstructor(null);
        declaredAnnotation.setAccessible(true);
        LazyMan lazyMan1 = declaredAnnotation.newInstance();
        //4.设置实例标志位为false，破环其单例
field.set(lazyMan1, false);

        //2.反射获取第二个实例
        LazyMan lazyMan2 = declaredAnnotation.newInstance();

        System.out.println(lazyMan1);
        System.out.println(lazyMan2);
    }

}
