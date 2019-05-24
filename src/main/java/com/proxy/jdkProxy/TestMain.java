package com.proxy.jdkProxy;

import java.lang.reflect.Proxy;

public class TestMain {

    /**
     * JDK 动态代理是实现
     * 主要涉及 reflect 中的两个类 ：Proxy 和 InvocationHandler
     *
     * InvacationHandler ：是一个接口， 通过实现该接口定义横切逻辑 ，并通过反射机制调用目标类的代码 动态的将横切逻辑和业务逻辑编织再一起
     *
     * Proxy ：利用 InvacationHandler 动态创建一个符合接口的实例，生成目标的代理对象
     *
     * 缺陷：致命的缺陷，只能为接口创建代理实例  这里 我们可以通过 CGLib 动态代理弥补这一缺陷
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.希望被代理的目标业务类
        JdkService target = new JdkServiceImpl();

        //2.将目标业务类和横切代码编织到一起
        JdkProxyHandler handler = new JdkProxyHandler(target);

        //3.根据编制了目标业务类逻辑和和性能简直横切逻辑的 InvocationHandler 实例创建代理实例
        JdkService proxy = (JdkService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);

        //调用方法
        proxy.addTopic(1);

        System.out.println("/***************控制台输出分割符**************/");

        proxy.removeTopic(1);
    }
    
}
