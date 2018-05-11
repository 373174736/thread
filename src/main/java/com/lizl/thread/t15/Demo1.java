package com.lizl.thread.t15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author lizl
 * @date 2018/5/11 14:21
 */
public class Demo1 {

    private int []nums;

    public Demo1(int line){
        nums = new int[line];
    }

    public void clac(String line, int index,CountDownLatch latch){
        System.out.println(Thread.currentThread().getName() + " 正在计算第" + index + "行数据");
        String [] nus = line.split(",");
        int total = 0;
        for(String s : nus){
            total +=Integer.parseInt(s);
        }
        nums[index] = total;
        System.out.println(Thread.currentThread().getName() + " 第" + index + "行数据计算完成，total=" + total);
        latch.countDown();
    }

    public void  sum(){
        System.out.println("汇总线程开始执行");
        int total = 0;
        for (int i = 0;i<nums.length;i++){
            total +=nums[i];
        }
        System.out.println("汇总线程执行完成 total=" + total);
    }

    public static void main(String []args){

        List<String> contents = readFile();
        int lineCount = contents.size();

        CountDownLatch latch = new CountDownLatch(lineCount);



        Demo1 d = new Demo1(lineCount);

        for(int i=0; i<lineCount; i++){
            final  int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    d.clac(contents.get(j),j,latch);
                }
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d.sum();
    }

    private static List<String> readFile() {
        List<String> contents = new ArrayList<>();
        String line ;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("d:\\nums.txt"));
            while ((line = br.readLine())!= null){
                contents.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           if(br != null){
               try {
                   br.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
        return  contents;
    }
}
