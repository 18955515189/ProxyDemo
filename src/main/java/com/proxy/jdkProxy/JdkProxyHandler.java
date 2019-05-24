package com.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JdkProxyHandler<T> implements InvocationHandler {
    T target; // 持有的被代理对象
    private static SimpleDateFormat simpleDateFormat ;

    static {
         simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public JdkProxyHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法开始时间："+simpleDateFormat.format(new Date()));
        Object o = method.invoke(target,args);
        System.out.println("方法结束时间："+simpleDateFormat.format(new Date()));
        return o;
    }
}
