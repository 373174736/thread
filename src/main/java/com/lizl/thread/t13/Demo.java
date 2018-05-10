package com.lizl.thread.t13;

/**
 * @author lizl
 * @date 2018/5/10 18:24
 */
public class Demo {

    public void a(Thread joinThread) {
        System.out.println("方法a执行了");
        joinThread.start();
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a方法执行完毕");
    }

    public void b(){
        System.out.println("加塞线程开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("加塞线程执行完毕");
    }

    public static void main(String []args){
        final Demo demo = new Demo();

        final Thread joinThread = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.b();
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a(joinThread);
            }
        }).start();

    }

}
