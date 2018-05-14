package com.lizl.thread.t19;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author lizl
 * @date 2018/5/14 17:03
 */
public class Demo {

    public static void main(String []args){
        Callable<Integer> call = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("正在计算结果");
                Thread.sleep(3000);
                return 1;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(call);

        Thread thread = new Thread(futureTask);
        thread.start();

        //do something
        System.out.println("干点别的....");

        Integer result = null;
        try {
            result = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("结果=" + result);

    }
}
