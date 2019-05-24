package com.proxy.cglibProxy;


public class CglibServiceImpl  {

    public void removeTopic(int topicId) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(topicId + "---删除成功 ");
    }

    public void addTopic(int topicId) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(topicId + "---新增成功 ");
    }

}
