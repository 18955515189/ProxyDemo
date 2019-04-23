package com.proxy.easyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Test<T> implements InvocationHandler {
    T target;

    public Test(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }
}
