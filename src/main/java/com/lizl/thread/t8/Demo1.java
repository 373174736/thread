package com.lizl.thread.t8;

public class Demo1 {

    private volatile int signal;

    public void set(int value){
        this.signal = value;
    }

    public int get(){
        return signal;
    }

    public static void main(String []args){
        Demo1 d = new Demo1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (d) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    d.set(1);
                    System.out.println("状态设置完成...");
                    d.notify();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (d){
                    while (d.get() != 1){
                        try {
                            d.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("模拟代码块 开始执行。。。");
                }
            }
        }).start();
    }
}
