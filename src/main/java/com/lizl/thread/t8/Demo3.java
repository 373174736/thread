package com.lizl.thread.t8;

import java.util.concurrent.TimeUnit;

public class Demo3 {
    private volatile int signal;

    public synchronized void set(){
        this.signal = 1;
        notifyAll();
    }

    public synchronized int get(){
        System.out.println(Thread.currentThread().getName() + "方法执行了、。、。、");
        if(signal != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "方法执行完毕");
        return signal;
    }


    public static void main(String []args){
        Demo3 demo3 = new Demo3();
        Target1 target1 = new Target1(demo3);
        Target2 target2 = new Target2(demo3);

        new Thread(target2).start();
        new Thread(target2).start();
        new Thread(target2).start();
        new Thread(target2).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(target1).start();

    }

}
