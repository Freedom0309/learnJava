package com.freedom.proxy.staticproxy;

/**
 * 静态代理对象
 *
 * @author liuf
 * date: 2020-02-08
 */
public class TeacherDaoProxy implements ITeacherDao {
    /**
     * 目标对象，通过接口来聚合
     */
    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理");
        target.teach();
    }
}
