package com.lizl.thread.t5;

public class Demo {
    MyLock lock = new MyLock();


    public void a(){
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }
    public void b(){
        lock.lock();
        System.out.println("b");
        lock.unlock();

    }

    public static void main(String []args){
        final Demo demo = new Demo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a();
//                demo.b();
            }
        }).start();
    }
}
