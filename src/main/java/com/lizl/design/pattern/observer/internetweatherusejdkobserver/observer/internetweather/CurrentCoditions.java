package com.lizl.design.pattern.observer.internetweatherusejdkobserver.observer.internetweather;

import com.lizl.design.pattern.observer.internetweatherusejdkobserver.observer.internetobserver.Observer;

import java.util.Observable;

/**
 * @author lizl
 * @date 2018/6/5 17:12
 */
public class CurrentCoditions implements java.util.Observer {

    private float mTemperatrue;
    private float mPressure;
    private float mHumidity;

    public void display(){
        System.out.println("***Todat mTemperatrue:" + mTemperatrue);
        System.out.println("***Todat mPressure:" + mPressure);
        System.out.println("***Todat mHumidity:" + mHumidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.mTemperatrue = ((WetherData.Data)arg).mTemperatrue;
        this.mPressure = ((WetherData.Data)arg).mPressure;
        this.mHumidity = ((WetherData.Data)arg).mHumidity;
        display();
    }
}
