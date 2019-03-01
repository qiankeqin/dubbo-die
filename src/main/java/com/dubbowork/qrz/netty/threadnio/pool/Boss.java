package com.dubbowork.qrz.netty.threadnio.pool;

import java.nio.channels.ServerSocketChannel;
/**
 * boss接口
 * @author 邱润泽
 *
 */
public interface Boss {
	
	/**
	 * 加入一个新的ServerSocket
	 * @param serverChannel
	 */
	public void registerAcceptChannelTask(ServerSocketChannel serverChannel);
}
