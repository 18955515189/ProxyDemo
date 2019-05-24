package com.proxy.cglibProxy;

public class CglibTest {
    public static void main(String[] args) throws Exception {
        CglibProxy proxy = new CglibProxy();
        CglibServiceImpl service = (CglibServiceImpl) proxy.getProxy(Class.forName("com.proxy.cglibProxy.CglibServiceImpl"));

        service.addTopic(1);
        System.out.println("/***************控制台输出分割符**************/");
        service.removeTopic(1);
    }
}
