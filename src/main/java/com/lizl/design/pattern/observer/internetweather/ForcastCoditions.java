package com.lizl.design.pattern.observer.internetweather;

import com.lizl.design.pattern.observer.internetobserver.Observer;

/**
 * @author lizl
 * @date 2018/6/5 17:12
 */
public class ForcastCoditions implements Observer {

    private float mTemperatrue;
    private float mPressure;
    private float mHumidity;

    @Override
    public void update(float mTemperatrue, float mPressure, float mHumidity) {
        this.mTemperatrue = mTemperatrue;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        display();
    }

    public void display(){
        System.out.println("***Tomorrow mTemperatrue:" + mTemperatrue);
        System.out.println("***Tomorrow mPressure:" + mPressure);
        System.out.println("***Tomorrow mHumidity:" + mHumidity);
    }
}
