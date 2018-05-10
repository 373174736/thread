package com.lizl.thread.t8;

public class Demo {

    private volatile int signal;

    public void set(int value){
        this.signal = value;
    }

    public int get(){
        return signal;
    }

    public static void main(String []args){
        Demo d = new Demo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                d.set(1);
                System.out.println("状态设置完成...");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (d.get() != 1){

                }
                System.out.println("模拟代码块 开始执行。。。");
            }
        }).start();
    }
}
