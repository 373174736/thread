package com.lizl.thread.t7;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {

    private HashMap<String, Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock r = lock.readLock();

    private Lock w = lock.writeLock();

    private boolean isUpdate;

    public void readWrite(){
        r.lock();
        if(isUpdate){
            r.unlock();
            w.lock();
            map.put("xxx", "xxx");
            r.lock();//将写锁 降级为读锁
            w.unlock();
        }

        Object obj = map.get("xxx");
        r.unlock();
        System.out.println(obj);
    }

    public Object get(String key){
        r.lock();
        System.out.println(Thread.currentThread().getName() + "读操作 正在进行。。。");
        try{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    public void set(String key, Object value){
        w.lock();
        System.out.println(Thread.currentThread().getName() + "写操作正在进行。。。");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        }finally {
            w.unlock();
        }
    }
}
