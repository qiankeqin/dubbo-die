package com.dubbowork.qrz.service;

import com.dubbowork.qrz.RpcFrameWork;

/**
 * @author 邱润泽 bullock
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFrameWork.export(service, 1234);
    }
}
