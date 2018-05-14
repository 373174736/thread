package com.lizl.thread.t20;

/**
 * @author lizl
 * @date 2018/5/14 17:18
 */
public class Demo {

    public static void main(String []args){
        ProductFactory factory = new ProductFactory();
        Future f = factory.createProduct("hello");

        System.out.println("下了班来取蛋糕");

        System.out.println("取到蛋糕" + f.getProduct());

    }
}
