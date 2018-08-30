package com.lizl.thread.t26;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author lizl
 * @date 2018/5/21 13:45
 */
public class Demo {

    public static void main(String []args){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS ,new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
        //固定大小线程池
        ExecutorService pool = Executors.newFixedThreadPool(10, namedThreadFactory);
        //


        while (true){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
}
