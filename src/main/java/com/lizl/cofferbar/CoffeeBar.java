package com.lizl.cofferbar;

import com.lizl.cofferbar.coffee.Decaf;
import com.lizl.cofferbar.coffee.LongBlack;
import com.lizl.cofferbar.decorator.Chocolate;
import com.lizl.cofferbar.decorator.Milk;

/**
 * @author lizl
 * @date 2018/6/6 18:17
 */
public class CoffeeBar {

    public static void main(String[] args) {
        Drink order;
        order = new Decaf();
        System.out.println("order1 price:" + order.cost());
        System.out.println("order1 desc:" + order.getDescription());

        System.out.println("*******************************");

        order = new LongBlack();
        order = new Milk(order);
        order = new Chocolate(order);
        order = new Chocolate(order);
        System.out.println("order2 price:" +order.cost());
        System.out.println("order2 desc:" + order.getDescription());
    }
}
