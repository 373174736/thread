package com.lizl.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lizl
 * @date 2018/6/13 11:40
 */
public class DynamicProxy implements InvocationHandler {

    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before rent house");

        System.out.println("method:" +  method);

        method.invoke(subject, args);

        System.out.println("after rent house");

        return null;
    }
}
