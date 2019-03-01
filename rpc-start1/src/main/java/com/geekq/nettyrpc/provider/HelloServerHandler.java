package com.geekq.nettyrpc.provider;

import com.geekq.nettyrpc.service.impl.HelloServiceImpl;
import com.geekq.nettyrpc.test.ClientBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author 邱润泽 bullock
 */
public class HelloServerHandler  extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        // 如何符合约定，则调用本地方法，返回数据
        if (msg.toString().startsWith(ClientBootstrap.providerName)) {
            String result = new HelloServiceImpl()
                    .hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }
    }

}
