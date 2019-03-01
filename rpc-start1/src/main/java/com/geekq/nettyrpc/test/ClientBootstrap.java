package com.geekq.nettyrpc.test;

import com.geekq.nettyrpc.consumer.RpcConsumer;
import com.geekq.nettyrpc.service.HelloService;

/**
 * @author 邱润泽 bullock
 */
public class ClientBootstrap {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws InterruptedException {

        RpcConsumer consumer = new RpcConsumer();
        // 创建一个代理对象
        HelloService service = (HelloService) consumer
                .createProxy(HelloService.class, providerName);
        for (; ; ) {
            Thread.sleep(1000);
            System.out.println(service.hello("are you ok ?"));
        }
    }

}
