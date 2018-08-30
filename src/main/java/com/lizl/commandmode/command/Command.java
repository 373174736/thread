package com.lizl.commandmode.command;

/**
 * @author lizl
 * @date 2018/6/7 16:04
 */
public interface Command {

    public void execute();
    public void undo();
}
