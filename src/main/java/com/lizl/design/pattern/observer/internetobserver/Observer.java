package com.lizl.design.pattern.observer.internetobserver;

/**
 * @author lizl
 * @date 2018/6/5 17:00
 * 观察者
 */
public interface Observer {
    /**
     *
     * @param mTemperatrue
     * @param mPressure
     * @param mHumidity
     */
    public void update(float mTemperatrue, float mPressure, float mHumidity);
}
