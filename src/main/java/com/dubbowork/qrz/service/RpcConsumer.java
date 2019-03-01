package com.dubbowork.qrz.service;

import com.dubbowork.qrz.RpcFrameWork;

/**
 * @author 邱润泽 bullock
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService service = RpcFrameWork.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }

}
