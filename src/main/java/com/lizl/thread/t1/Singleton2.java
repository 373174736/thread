package com.lizl.thread.t1;

/***
 * @author lizl
 */
public class Singleton2 {

    //私有化构造函数

    /**
     *
     */
    private Singleton2(){

    }

    private static volatile Singleton2 instance;

    /**
     * 双重检查加锁
     * @return
     */
    public static Singleton2 getInstance(){
        if(instance == null){
            synchronized (Singleton2.class){
                if(instance == null){
                    //指令重排序
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

}
