//package com.tc.event.netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//
///**
// * Server
// */
//public class SimpleChatServer {
//    private static int port = 8080;
//
//    public SimpleChatServer(int port) {
//        this.port = port;
//    }
//
//    public void run() throws Exception {
//        //创建mainReactor。监听Accept连接建立事件和分发请求
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        //创建subReactor即workReactor。处理IO读写事件
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            //组装NioEventLoopGroup
//            serverBootstrap.group(bossGroup, workerGroup)
//                    //设置Channel为Nio类型
//                    .channel(NioServerSocketChannel.class)
//                    //配置入站、出站事件Handler
//                    .childHandler(new SimpleChatServerInitializer())
//
//                    //设置连接配置参数
//                    .option(ChannelOption.SO_BACKLOG, 128)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true);
//
//            System.out.println("server 启动了");
//
//            // 绑定端口，开始接收进来的连接
//            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
//
//            // 等待服务器  socket 关闭 。
//            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
//            channelFuture.channel().closeFuture().sync();
//
//        } finally {
//            workerGroup.shutdownGracefully();
//            bossGroup.shutdownGracefully();
//            System.out.println("server 关闭了");
//        }
//    }
//
//
//
//    public static void main(String[] args) throws Exception
//    {
//        new SimpleChatServer(port).run();
//    }
//}
