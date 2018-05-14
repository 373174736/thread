package com.lizl.thread.t20;

/**
 * @author lizl
 * @date 2018/5/14 17:26
 */
public class ProductFactory {

    public Future createProduct(String name){
        Future f = new Future();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //生产
                Product p = new Product(1,name);
                f.setProduct(p);
            }
        }).start();
        return f;
    }
}
