package com.lizl.commandmode.command;

/**
 * @author lizl
 * @date 2018/6/7 16:54
 */
public interface Control {

    public void onButton(int slot);
    public void offButton(int slot);
    public void undoButton();
}
