package com.lizl.thread.t8;

public class Target2 implements Runnable {


    private Demo3 demo3 ;

    public Target2(Demo3 demo3){
        this.demo3 = demo3;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "      "+ demo3.get());
    }
}
