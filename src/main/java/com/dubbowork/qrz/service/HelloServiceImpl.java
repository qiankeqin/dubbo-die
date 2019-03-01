package com.dubbowork.qrz.service;

/**
 * @author 邱润泽 bullock
 */
public class HelloServiceImpl   implements  HelloService{

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
