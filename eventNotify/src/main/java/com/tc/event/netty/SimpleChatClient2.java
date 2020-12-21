//package com.tc.event.netty;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.Channel;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioSocketChannel;
//
//import java.util.Scanner;
//
//public class SimpleChatClient2 {
//    private static String host = "localhost";
//    private static int port = 8080;
//
//
//    public static void main(String[] args){
//        new SimpleChatClient2(host, port).run();
//    }
//
//    public SimpleChatClient2(String host, int port) {
//        this.host = host;
//        this.port = port;
//    }
//
//
//    public void run(){
//        EventLoopGroup group = new NioEventLoopGroup();
//        try {
//            Bootstrap bootstrap  = new Bootstrap()
//                    .group(group)
//                    .channel(NioSocketChannel.class)
//                    .handler(new SimpleChatClientInitializer());
//            Channel channel = bootstrap.connect(host, port).sync().channel();
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("please enter...");
//            boolean exit = false;
//            // 输入exit，退出系统
//            while(!exit)
//            {
//                String str = scanner.next();
//                channel.writeAndFlush(str + "\r\n");
//                if(str.equalsIgnoreCase("exit"))
//                {
//                    exit = true;
//                    channel.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            group.shutdownGracefully();
//        }
//    }
//}
