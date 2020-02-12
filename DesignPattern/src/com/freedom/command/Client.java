package com.freedom.command;

/**
 * @author liuf
 * date: 2020-02-12
 */
public class Client {
    public static void main(String[] args) {
        //使用命令模式，完成通过遥控器，对电灯的操作
        //创建电灯的对象
        LightReceiver receiver = new LightReceiver();

        //创建电灯开关的相关命令
        LightOnCommand lightOnCommand = new LightOnCommand(receiver);
        LightOffCommand lightOffCommand = new LightOffCommand(receiver);

        //遥控器
        RemoteController remoteController = new RemoteController();
        //给遥控器设置命令
        remoteController.setCommands(0, lightOnCommand, lightOffCommand);

        System.out.println("------------------");
        remoteController.onButtonWasPushed(0);
        System.out.println("------------------");
        remoteController.offButtonWasPushed(0);
        System.out.println("------------------");
        remoteController.undoButtonWasPushed();
    }
}
