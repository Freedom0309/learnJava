package com.freedom.command;

/**
 * @author liuf
 * date: 2020-02-12
 */
public class LightOnCommand implements Command {
    //聚合LightReceiver
    private LightReceiver receiver;

    public LightOnCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.on();
    }

    @Override
    public void undo() {
        receiver.off();
    }
}
