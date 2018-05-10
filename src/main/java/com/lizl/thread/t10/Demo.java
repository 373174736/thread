package com.lizl.thread.t10;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {

    private  int signal;
    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void a(){
        lock.lock();
        while (signal != 0){
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        signal ++;
        b.signal();
        lock.unlock();
    }
    public void b(){
        lock.lock();
        while (signal != 1){
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal ++;
        c.signal();
        lock.unlock();
    }
    public void c(){
        lock.lock();
        while (signal != 2){
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal ++;
        a.signal();
        lock.unlock();
    }

    public static void main(String []args){
        Demo d = new Demo();

    }

}
