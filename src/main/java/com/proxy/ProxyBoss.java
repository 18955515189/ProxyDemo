package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBoss {
    /**
     * 对接口方法进行代理
     */
    @SuppressWarnings("unchecked")
    /**
     * 动态代理工具方法
     */
    public static <T> T getProxy(final int discountCoupon,
                                 final Class<?> interfaceClass, final Class<?> implementsClass)
            throws Exception {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass}, new InvocationHandler() {
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        Integer returnValue = (Integer) method.invoke(
                                implementsClass.newInstance(), args);// 调用原始对象以后返回的值
                        return returnValue - discountCoupon;
                    }
                });
    }

    public static void main(String[] args) throws Exception {
        BuyMethodServiceImpl buyMethodService = new BuyMethodServiceImpl();
        System.out.println( "正常价格："+ buyMethodService.getYifu("aaa"));

        BuyMethodService buy = getProxy(100, BuyMethodService.class, BuyMethodServiceImpl.class);
        System.out.println( "动态代理后会员价格："+ buy.getYifu("aaa"));
    }
}
