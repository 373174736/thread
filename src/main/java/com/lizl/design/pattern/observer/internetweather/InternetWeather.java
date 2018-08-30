package com.lizl.design.pattern.observer.internetweather;

/**
 * @author lizl
 * @date 2018/6/5 17:40
 */
public class InternetWeather {
    public static void main(String[] args) {
        CurrentCoditions currentCoditions = new CurrentCoditions();
        ForcastCoditions forcastCoditions = new ForcastCoditions();

        WetherData wetherData = new WetherData();
        wetherData.registerObserver(currentCoditions);
        wetherData.registerObserver(forcastCoditions);

        wetherData.setData(50, 150, 250);
        wetherData.removeObserver(currentCoditions);
        wetherData.setData(51, 151, 251);

    }
}
