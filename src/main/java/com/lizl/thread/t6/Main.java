package com.lizl.thread.t6;

public class Main {

    private int value;
    private MyLock lock = new MyLock();

    public int next(){
        lock.lock();
        value ++;
        lock.unlock();
        return value;
    }


    public void a(){
        lock.lock();
        System.out.println("A");
        b();
        lock.unlock();
    }

    public void b(){
        lock.lock();
        System.out.println("B");
        lock.unlock();
    }


    public static void main(String[] args){

        Main m = new Main();

        new Thread(new Runnable() {
            @Override
            public void run() {
                m.a();
            }
        }).start();
    }
}
