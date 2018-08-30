package com.lizl.cofferbar.decorator;

import com.lizl.cofferbar.Drink;

/**
 * @author lizl
 * @date 2018/6/6 17:05
 *
 * 装饰者分之的中间层
 *
 */
public class Decorator extends Drink {

    private Drink obj;

    public Decorator(Drink obj){
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDescription() {
        return super.description + "-" + super.getPrice() + "&&" + obj.getDescription();
    }
}
