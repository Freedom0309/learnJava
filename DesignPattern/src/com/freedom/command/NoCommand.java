package com.freedom.command;

/**
 * 无操作：用于初始化每个按钮，当调用空命令时，对象不做任何操作
 * 其实这也是一种设计模式，可以省掉对空的判断
 * @author liuf
 * date: 2020-02-12
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
