package com.lizl.thread.t9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tmall {

    private int count;

    public final int MAX_COUNT = 10;

    Lock lock = new ReentrantLock();

    Condition push = lock.newCondition();
    Condition take = lock.newCondition();

    public  void push(){
        lock.lock();
        if(count >= MAX_COUNT){
            try {
                System.out.println(Thread.currentThread().getName() + "库存数量达到上限，生产者停止生产");
                push.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "生产者生产，当前库存为:" + count);
        take.signal();
        lock.unlock();

    }

    public void take(){
        lock.lock();
        if(count <= 0){
            try {
                System.out.println(Thread.currentThread().getName() + "库存为0，消费者等待");
                take.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "消费者消费，当前库存为:" + count);
        push.signal();
        lock.unlock();
    }
}
