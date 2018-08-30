package com.lizl.commandmode.command;

/**
 * @author lizl
 * @date 2018/6/7 16:38
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
