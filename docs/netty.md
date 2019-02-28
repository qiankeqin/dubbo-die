## netty 阅读理解


#### [阅读netty 书籍权威指南 下载](/docs/netty.pdf)

1.选择netty作为nio底层通讯框架

1.1.阅读《Netty权威指南 第2版 带书签目录 完整版.pdf》

1.2.了解io，nio，netty的关系

1.3.了解TCP粘包／拆包问题现象和解决方法

TCP是个”流”协议，所谓流，就是没有界限的一串数据。TCP底层并不了解上层业务数据的具体含义，它会根据TCP缓冲区的实际情况进行包的划分，所以在业务上认为，一个完整的包可能会被TCP拆分成多个包进行发送，也有可能把多个小的包封装成一个大的数据包发送，这就是所谓的TCP粘包和拆包问题

1.4.了解netty自带编解码器

1.4.1.LineBaseFrameDecoder 换行符作为码流结束标识，解决TCP粘包／拆包问题

1.4.2.DelimiterBasedFrameDecoder 以特殊分隔符作为码流结束标识，比如$_，解决TCP粘包／拆包问题

1.4.3.FixedLengthFrameDecoder 固定长度解码器，解决TCP粘包／拆包问题

1.4.4.LengthFieldBasedFrameDecoder 自定义长度解码器(消息头固定位置增加一个表示长度的字段)，解决TCP粘包／拆包问题

1.4.4.StringEncoder和StringDecoder 字节和字符串互转

1.4.5.ObjectEncoder和ObjectDecoder 字节和对象互转，父类是LengthFieldBasedFrameDecoder

1.5.业界主流编解码框架 java序列化缺点：不能跨语言，码流大，性能低

1.5.1.Google的Protobuf

1.5.2.Facebook的Thrift

1.5.3.JBoss的Marshalling

1.5.4.msgpack

1.5.5.kryo

1.6.server端和client端编写

1.7.server端监听端口，接受client端发送消息处理并返回消息，client端接收到返回消息并打印