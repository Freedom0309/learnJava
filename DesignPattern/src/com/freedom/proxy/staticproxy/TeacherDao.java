package com.freedom.proxy.staticproxy;

/**
 * @author liuf
 * date: 2020-02-08
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("正字授课。。。。。。");
    }
}
