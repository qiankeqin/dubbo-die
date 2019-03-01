package com.geekq.nettyrpc.service.impl;

import com.geekq.nettyrpc.service.HelloService;

/**
 * @author 邱润泽 bullock
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String msg) {
        return msg != null ? msg + " -----> I am fine." : "I am fine.";
    }
}
