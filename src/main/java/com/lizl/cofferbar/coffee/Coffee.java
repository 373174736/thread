package com.lizl.cofferbar.coffee;

import com.lizl.cofferbar.Drink;

/**
 * @author lizl
 * @date 2018/6/6 16:36
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
