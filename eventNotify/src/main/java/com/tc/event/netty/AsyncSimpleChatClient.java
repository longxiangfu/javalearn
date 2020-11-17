package com.tc.event.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * 异步连接Server
 */
public class AsyncSimpleChatClient {
    private static String host = "localhost";
    private static int port = 8080;


    public static void main(String[] args){
        new AsyncSimpleChatClient(host, port).run();
    }

    public AsyncSimpleChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }


    public void run(){
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap  = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new SimpleChatClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect(host, port);
            //异步连接
            channelFuture.addListeners((ChannelFutureListener)future -> {
                if (future.isSuccess()) {
                    System.out.println("Connect successful!");
                    Channel channel = future.channel();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("please enter...");
                    boolean exit = false;
                    // 输入exit，退出系统
                    while(!exit)
                    {
                        String str = scanner.next();
                        channel.writeAndFlush(str + "\r\n");
                        if(str.equalsIgnoreCase("exit")){
                            exit = true;
                            channel.close();
                        }
                    }
                }else {
                    //连接失败
                    System.out.println("Connect failed");
                    Throwable cause = future.cause();
                    cause.printStackTrace();
                }
            });
            System.out.println("Finished connect operation2");
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
