package com.freedom.command;

/**
 * @author liuf
 * date: 2020-02-12
 */
public interface Command {
    /**
     * 执行操作
     */
    void execute();

    /**
     * 撤销操作
     */
    void undo();
}
