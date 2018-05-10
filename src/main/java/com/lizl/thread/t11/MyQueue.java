package com.lizl.thread.t11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue<E> {

    private Object[] obj;
    private int addIndex;
    private int removeIndex;
    private int queueSize;
    private Lock lock = new ReentrantLock();
    Condition add = lock.newCondition();
    Condition remove = lock.newCondition();

    public MyQueue(int count){
        obj = new Object[count];
    }

    public void add(E e){
        lock.lock();
        while (queueSize == obj.length){
            try {
                System.out.println(Thread.currentThread().getName() + "队列满了 不进行新增");
                add.await();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        obj[addIndex++] = e;
        if(++ addIndex == obj.length){
            addIndex = 0;
        }
        queueSize++;
        remove.signal();
        lock.unlock();
    }

    public void remove(){
        lock.lock();
        while (queueSize == 0){
            try {
                System.out.println(Thread.currentThread().getName() + "队列为空 不进行移除");
                remove.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        obj[removeIndex++] = null;

        if(++ removeIndex == obj.length){
            removeIndex = 0;
        }

        queueSize--;

        add.signal();
        lock.unlock();
    }


    public static void main(String []args){
        MyQueue<String> myQueue = new MyQueue<>(6);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    myQueue.add("1");
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    myQueue.remove();
                }
            }
        }).start();
    }
}
