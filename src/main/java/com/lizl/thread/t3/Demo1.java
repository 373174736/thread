package com.lizl.thread.t3;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo1 {

    private AtomicInteger value = new AtomicInteger();

    /**
     *
     */
    public int getNext(){
        return value.getAndAdd(10);
    }

    public static void main(String []args){
       Demo1 d1 = new Demo1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + "-" + d1.getNext());

                    try {
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + "-" + d1.getNext());

                    try {
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + "-" + d1.getNext());

                    try {
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
            }
        }).start();
    }
}
