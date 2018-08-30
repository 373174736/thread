package com.lizl.commandmode.command;

import java.util.Stack;

/**
 * @author lizl
 * @date 2018/6/7 16:46
 */
public class CommandModeControl  implements Control {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> stack = new Stack<>();

    public CommandModeControl() {

        onCommands = new Command[5];
        offCommands = new Command[5];
        Command noCommand = new NoCommand();
        for(int i=0,len=offCommands.length;i<len;i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    @Override
    public void onButton(int slot){
        onCommands[slot].execute();
        stack.push(onCommands[slot]);
    }

    @Override
    public void offButton(int slot) {
        offCommands[slot].execute();
        stack.push(offCommands[slot]);
    }

    @Override
    public void undoButton() {
        stack.pop().undo();
    }
}
