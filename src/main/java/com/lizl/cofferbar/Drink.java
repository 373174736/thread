package com.lizl.cofferbar;

/**
 * @author lizl
 * @date 2018/6/6 16:09
 * 超类
 */
public abstract class Drink {

    public String description="";
    private float price=0f;

    public String getDescription() {
        return description + "-" + this.price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
