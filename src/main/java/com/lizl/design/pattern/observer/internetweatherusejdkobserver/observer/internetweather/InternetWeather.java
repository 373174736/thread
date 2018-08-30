package com.lizl.design.pattern.observer.internetweatherusejdkobserver.observer.internetweather;

/**
 * @author lizl
 * @date 2018/6/5 17:40
 */
public class InternetWeather {
    public static void main(String[] args) {
        CurrentCoditions currentCoditions = new CurrentCoditions();
        ForcastCoditions forcastCoditions = new ForcastCoditions();

        WetherData wetherData = new WetherData();
        wetherData.addObserver(currentCoditions);
        wetherData.addObserver(forcastCoditions);

        wetherData.setData(50, 150, 250);
        wetherData.deleteObserver(currentCoditions);
        wetherData.setData(51, 151, 251);

    }
}
