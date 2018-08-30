package com.lizl.commandmode.command;

/**
 * @author lizl
 * @date 2018/6/7 16:41
 */
public class Light {

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Light(String desc) {
        this.desc = desc;
    }

    public void on(){
            System.out.println(getDesc() + "on");
    }

    public void off(){
            System.out.println(getDesc() + "off");
    }
}
