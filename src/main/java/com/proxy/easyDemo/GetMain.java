package com.proxy.easyDemo;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class GetMain {
    
    public static void main(String[] args) {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
        String path = "E:/StuProxy.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
    
}
