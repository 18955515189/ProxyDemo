package com.proxy.cglibImpl;

/**
 *
 * Created by david on 2018/6/3.
 */
public class UserServiceImpl implements UserService{

    @Override
    public String getName(int id) {
        System.out.println("------getName------");
        return "Tom";
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("------getAge------");
        return 10;
    }

}
