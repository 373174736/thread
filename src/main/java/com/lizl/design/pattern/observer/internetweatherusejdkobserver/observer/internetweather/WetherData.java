package com.lizl.design.pattern.observer.internetweatherusejdkobserver.observer.internetweather;

import java.util.Observable;

/**
 * @author lizl
 * @date 2018/6/5 17:23
 */
public class WetherData extends Observable {
    private float mTemperatrue;
    private float mPressure;
    private float mHumidity;

    public float getmTemperatrue() {
        return mTemperatrue;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }

    public WetherData(){

    }

    public void dataChange(){
        this.setChanged();
        this.notifyObservers(new Data(getmTemperatrue(), getmPressure(), getmHumidity()));
    }

    public void setData(float mTemperatrue, float mPressure, float mHumidity){
        this.mTemperatrue = mTemperatrue;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        dataChange();
    }

    public class Data{
        public float mTemperatrue;
        public float mPressure;
        public float mHumidity;

        public Data(float mTemperatrue, float mPressure, float mHumidity){
            this.mTemperatrue = mTemperatrue;
            this.mPressure = mPressure;
            this.mHumidity = mHumidity;
        }
    }
}
