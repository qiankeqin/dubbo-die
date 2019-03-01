package com.geekq.nettyrpc.test;

import com.geekq.nettyrpc.provider.NettyServer;

/**
 * @author 邱润泽 bullock
 */
public class ServerBootstrap {

    public static void main(String[] args) {
        NettyServer.startServer0("localhost",10101);
    }
}
