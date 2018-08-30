package com.lizl.design.pattern.observer.internetobserver;

/**
 * @author lizl
 * @date 2018/6/5 17:07
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
