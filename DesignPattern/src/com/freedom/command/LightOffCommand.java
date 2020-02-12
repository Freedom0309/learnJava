package com.freedom.command;

/**
 * @author liuf
 * date: 2020-02-12
 */
public class LightOffCommand implements Command {
    //聚合LightReceiver
    private LightReceiver receiver;

    public LightOffCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.off();
    }

    @Override
    public void undo() {
        receiver.on();
    }
}
