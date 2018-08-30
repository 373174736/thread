package com.lizl.commandmode.command;

/**
 * @author lizl
 * @date 2018/6/7 16:38
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
