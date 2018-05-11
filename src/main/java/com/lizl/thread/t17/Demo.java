package com.lizl.thread.t17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author lizl
 * @date 2018/5/11 16:01
 */
public class Demo {

    public void method(Semaphore semaphore){

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is run...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();
    }

    public static void main(String []args){
        ExecutorService pool =Executors.newFixedThreadPool(100);
        Semaphore semaphore = new Semaphore(10);
        Demo demo = new Demo();
        while (true){

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    demo.method(semaphore);
                }
            });
        }

    }


}
