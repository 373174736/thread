package com.lizl.thread.t20;

/**
 * @author lizl
 * @date 2018/5/14 17:29
 */
public class Future {

    private Product product;
    private boolean down;

    public synchronized Product getProduct() {
        while (!down){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    public synchronized void setProduct(Product product) {
        if(down){
            return;
        }
        this.product = product;
        this.down = true;
        notifyAll();
    }
}
