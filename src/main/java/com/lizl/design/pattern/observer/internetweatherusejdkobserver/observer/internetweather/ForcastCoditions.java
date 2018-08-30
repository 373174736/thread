package com.lizl.design.pattern.observer.internetweatherusejdkobserver.observer.internetweather;


import java.util.Observable;
import java.util.Observer;

/**
 * @author lizl
 * @date 2018/6/5 17:12
 */
public class ForcastCoditions implements Observer {

    private float mTemperatrue;
    private float mPressure;
    private float mHumidity;

    public void display(){
        System.out.println("***Tomorrow mTemperatrue:" + mTemperatrue);
        System.out.println("***Tomorrow mPressure:" + mPressure);
        System.out.println("***Tomorrow mHumidity:" + mHumidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.mTemperatrue = ((WetherData.Data)arg).mTemperatrue;
        this.mPressure = ((WetherData.Data)arg).mPressure;
        this.mHumidity = ((WetherData.Data)arg).mHumidity;
        display();
    }
}
