package com.lizl.commandmode.command;

/**
 * @author lizl
 * @date 2018/6/7 17:20
 */
public class MarcoCommand implements Command {

    private Command[] commands;

    public MarcoCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for(Command command :commands){
            command.execute();
        }
    }

    @Override
    public void undo() {
        for(Command command :commands){
            command.undo();
        }
    }
}
