package com.freedom.command;

/**
 * @author liuf
 * date: 2020-02-12
 */
public class RemoteController {
    Command[] onCommands;
    Command[] offCommands;

    //执行撤销命令
    Command undoCommands;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();

        }
    }

    public void setCommands(int index, Command onCommand, Command offCommand) {
        onCommands[index] = onCommand;
        offCommands[index] = offCommand;
    }

    /**
     * 按下打开按钮
     *
     * @param num
     */
    public void onButtonWasPushed(int num) {
        //找到按下的打开按钮，并调用对应的方法
        onCommands[num].execute();
        //记录这次的操作，用于撤销
        undoCommands = onCommands[num];
    }

    /**
     * 按下关闭按钮
     *
     * @param num
     */
    public void offButtonWasPushed(int num) {
        //找到按下的关闭按钮，并调用对应方法
        offCommands[num].execute();
        //记录这次的操作，用于撤销
        undoCommands = offCommands[num];
    }

    /**
     * 按下撤销按钮
     */
    public void undoButtonWasPushed() {
        undoCommands.undo();
    }
}
