package com.lizl.cofferbar.decorator;

import com.lizl.cofferbar.Drink;

/**
 * @author lizl
 * @date 2018/6/6 18:04
 */
public class Milk extends Decorator{
    public Milk(Drink obj){
        super(obj);
        super.setDescription("Milk");
        super.setPrice(4.0f);
    }
}
