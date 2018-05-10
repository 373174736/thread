package com.lizl.thread.t1;

public class Singleton {

    //私有化构造方法
    private Singleton(){

    }

    //私有实例
    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}
