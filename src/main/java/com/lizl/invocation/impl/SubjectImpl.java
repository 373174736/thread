package com.lizl.invocation.impl;

import com.lizl.invocation.Subject;

/**
 * @author lizl
 * @date 2018/6/13 11:29
 */
public class SubjectImpl implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello " + str);
    }
}
