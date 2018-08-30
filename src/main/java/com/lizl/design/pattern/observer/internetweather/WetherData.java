package com.lizl.design.pattern.observer.internetweather;

import com.google.common.collect.Lists;
import com.lizl.design.pattern.observer.internetobserver.Observer;
import com.lizl.design.pattern.observer.internetobserver.Subject;

import java.util.List;

/**
 * @author lizl
 * @date 2018/6/5 17:23
 */
public class WetherData implements Subject {
    private float mTemperatrue;
    private float mPressure;
    private float mHumidity;
    private List<Observer> observers;
    public WetherData(){
        observers = Lists.newArrayList();
    }

    public float getmTemperatrue() {
        return mTemperatrue;
    }

    public float getmPressure() {
        return mPressure;
    }

    public float getmHumidity() {
        return mHumidity;
    }

    public void setData(float mTemperatrue, float mPressure, float mHumidity){
        this.mTemperatrue = mTemperatrue;
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        dataChange();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(observers.contains(o)){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers){
            o.update(getmTemperatrue(), getmPressure(), getmHumidity());
        }
    }

    public void dataChange(){
        notifyObservers();
    }
}
