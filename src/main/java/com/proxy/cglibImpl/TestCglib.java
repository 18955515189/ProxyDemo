package com.proxy.cglibImpl;

import com.proxy.BuyMethodService;
import com.proxy.BuyMethodServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * cglib 动态代理插件配置
 * Created by david on 2018/6/3.
 */
public class TestCglib {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService o = (UserService)enhancer.create();
        o.getName(1);
        o.getAge(1);
    }
}
