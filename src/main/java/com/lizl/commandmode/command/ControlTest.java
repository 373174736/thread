package com.lizl.commandmode.command;

/**
 * @author lizl
 * @date 2018/6/7 16:58
 */
public class ControlTest {

    public static void main(String[] args) {
        CommandModeControl control = new CommandModeControl();
        Light bedRoomLight = new Light("BedRoom");


        LightOnCommand bedroomLighton = new LightOnCommand(bedRoomLight);
        LightOffCommand bedroomLightoff = new LightOffCommand(bedRoomLight);

        control.setCommand(0, bedroomLighton, bedroomLightoff);
//        control.onButton(0);
//        control.offButton(0);
//        control.undoButton();

        Command[] commands = {new LightOnCommand(bedRoomLight), new LightOffCommand(bedRoomLight)};

        MarcoCommand marcoCommand = new MarcoCommand(commands);
        control.setCommand(1, marcoCommand, marcoCommand);
        control.onButton(1);
//        control.offButton(1);

    }
}
