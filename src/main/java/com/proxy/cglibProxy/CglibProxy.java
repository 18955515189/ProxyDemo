package com.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    private static SimpleDateFormat simpleDateFormat ;
    static {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public Object getProxy(Class clazz){
        //1.设置需要的子类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //2.通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //3.拦截父类所有方法的调用
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法开始时间："+simpleDateFormat.format(new Date()));
        Object o1 = methodProxy.invokeSuper(o, args);
        System.out.println("方法结束时间："+simpleDateFormat.format(new Date()));
        return o1;
    }
}
