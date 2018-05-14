package com.lizl.thread.t18;

import java.util.concurrent.Exchanger;

/**
 * @author lizl
 * @date 2018/5/11 18:19
 */
public class Demo {

    public void a(Exchanger<String> exch){
        System.out.println("a 方法正在抓取数据");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String res = "123";

        try {
            String value = exch.exchange(res);
            System.out.println("b方法抓取完成。。。value=" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void b(Exchanger<String> exch){
        System.out.println("b 方法正在抓取数据");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String res = "123";

        try {
            String value = exch.exchange(res);
            System.out.println("a 方法抓取完成 value=" + value);
            System.out.println("开始进行比对 ,结果为" + value.equals(res));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String []args){
        Demo d = new Demo();
        Exchanger<String> exch = new Exchanger<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                d.a(exch);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                d.b(exch);
            }
        }).start();
    }

}
