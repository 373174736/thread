package com.lizl.thread.t2;

public class Main {

    private synchronized void  a(){
        System.out.println("a");
        b();
    }
    private synchronized void  b(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b");
    }

    public static void main(String []args){
        Main m1 = new Main();
        Main m2 = new Main();


        new Thread(new Runnable() {
            @Override
            public void run() {
                m1.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                m2.b();
            }
        }).start();


    }

}
