package com.lizl.cofferbar.decorator;

import com.lizl.cofferbar.Drink;

/**
 * @author lizl
 * @date 2018/6/6 18:11
 */
public class Soy extends Decorator {

    public Soy(Drink obj){
        super(obj);
        super.setDescription("Soy");
        super.setPrice(8.0f);
    }
}
