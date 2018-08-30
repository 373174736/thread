package com.lizl.thread.t25;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizl
 * @date 2018/5/21 10:48
 */
public class Demo {

    public static void main(String []args){
        AtomicInteger count = new AtomicInteger();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.DAYS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardOldestPolicy());
        for(int i = 0 ;i< 100 ;i++){
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    count.getAndIncrement();
                }
            });
        }
        threadPoolExecutor.shutdown();
    }
}
