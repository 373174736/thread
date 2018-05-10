package com.lizl.thread.t2;

/**
 * @author lizl
 *
 */
public class Demo1 {

   public static void main(String []args){
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName());
           }
       }).start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName());
           }
       }).start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName());
           }
       }).start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName());
           }
       }).start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName());
           }
       }).start();


       while (Thread.activeCount() != 1){
           //自旋
       }

       System.out.println("所有县城执行完毕");
   }
}
