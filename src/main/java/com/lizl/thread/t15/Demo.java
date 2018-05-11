package com.lizl.thread.t15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lizl
 * @date 2018/5/11 14:21
 */
public class Demo{

    private int []nums;

    public Demo(int line){
        nums = new int[line];
    }

    public void clac(String line, int index){
        System.out.println(Thread.currentThread().getName() + " 正在计算第" + index + "行数据");
        String [] nus = line.split(",");
        int total = 0;
        for(String s : nus){
            total +=Integer.parseInt(s);
        }
        nums[index] = total;
        System.out.println(Thread.currentThread().getName() + " 第" + index + "行数据计算完成，total=" + total);
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
        Demo d = new Demo(lineCount);

        for(int i=0; i<lineCount; i++){
            final  int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    d.clac(contents.get(j),j);
                }
            }).start();
        }

        while (Thread.activeCount() >1){
            //自旋一下 等待线程执行完成
            //但是这里非常耗费cpu资源。使用CountDownlatch 来处理这种情况
        }
        d.sum();
    }

    private static List<String> readFile() {
        List<String> contents = new ArrayList<>();
        String line = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("d:\\nums.txt"));
            while ((line = br.readLine())!= null){
                contents.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
        return  contents;
    }
}
