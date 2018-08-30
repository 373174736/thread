package com.lizl.thread.t24;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Tmall {

    public final int MAX_COUNT = 10;
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(MAX_COUNT);

    public  void push(){
        try {
            queue.put(1);
            System.out.println("放入一个");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void take(){
        try {
            queue.take();
            System.out.println("取出一个");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
