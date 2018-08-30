package com.lizl.cofferbar.decorator;

import com.lizl.cofferbar.Drink;

/**
 * @author lizl
 * @date 2018/6/6 17:59
 */
public class Chocolate extends Decorator{

    public Chocolate(Drink obj){
        super(obj);
        super.setDescription("Chocolate");
        super.setPrice(3.0f);
    }
}
