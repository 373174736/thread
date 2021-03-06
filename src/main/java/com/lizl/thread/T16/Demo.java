package com.lizl.thread.T16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lizl
 * @date 2018/5/11 15:24
 */

/**
 * 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier。
 *
 * CyclicBarrier 支持一个可选的 Runnable 命令，在一组线程中的最后一个线程到达之后（但在释放所有线程之前），该命令只在每个屏障点运行一次。若在继续所有参与线程之前更新共享状态，此屏障操作 很有用。
 */
public class Demo {

    public void metting(CyclicBarrier cyclicBarrier){
        System.out.println(Thread.currentThread().getName() + " 线程 到达会议室等待开会。。。");
        if(Thread.currentThread().getName().equals("Thread-7")){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cyclicBarrier.reset();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String []args){
        Demo demo = new Demo();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有人已经到达，会议即将开始。。。");
            }
        });
        for(int i=0 ;i<20 ;i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.metting(cyclicBarrier);
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前等待线程个数为:" + cyclicBarrier.getNumberWaiting());
                    System.out.println(cyclicBarrier.isBroken());
                }
            }
        }).start();

    }

}
