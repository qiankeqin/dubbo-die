## netty 阅读理解


#### [阅读netty 书籍权威指南 下载](/docs/netty.pdf)

**阻塞与非阻塞**

1.理解阻塞I/O--非阻塞I/O

阻塞的情况下：从网络流中读取不到指定大小的数据量，阻塞io就会一直在那里等待，已知有10个字节要传过来，但是你现在只收到了8个字节那么当前的线程就会在那里傻傻
等待`inputStream.read`，`server.accept()`阻塞点，详情见代码Oioserver.java

        单线程情况下只能有一个客户端
        用线程池可以有多个客户端连接，但是非常消耗性能

非阻塞的情况下：从网络流中读取不到指定大小的数据量，非阻塞IO 会立即放行，去处理别的事情，已知有10个字节传输过来，但是你只收到了8个字节，那么
当前线程只会读取这8个字节，然后去里别的事情，等待另外俩个字节再次到来的时候在处理！

            selector.select()  具体见代码 NIOServer.java
            selector.select(1000);不阻塞
            selector.wakeup();也可以唤醒selector
            selector.selectNow();也可以立马返还
            SelectionKey.OP_WRITE 代表OP_WRITE表示底层缓冲区是否有空间，是则响应返还true

**举例**

接一杯水，阻塞大哥会一直等待这杯水接满才可以，不然他就不会离开，其他的人也不会接，除非你去另一个水龙头（多线程耗费资源），而非阻塞小弟接完了发现
水只有3/4那么只要没水了他就会离开做别的事情！

**netty应用**

1.netty的版本大致分为3.x,4.x,5.x 

2.大部分的rpc底层的通信都是运用netty通信，速度快，性能好

3.编写客户端和服务端实例（详情见代码 client server）

    channelDisconnected与channelClosed的区别？
    channelDisconnected只有在连接建立后断开才会调用
    channelClosed无论连接是否成功都会调用关闭资源
    
**如何搭建一个多线程的NIO系统**