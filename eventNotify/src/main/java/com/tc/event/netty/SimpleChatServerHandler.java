package com.tc.event.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 事件处理器
 * 事件处理调用流程 handlerAdded -- channelActive -- messageReceived -- exceptionCaught -- channelInactive -- handlerRemoved（加入--在线--接收消息--异常--掉线--离开）
 */
public class SimpleChatServerHandler extends SimpleChannelInboundHandler<String> {
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 当一个客户端连接上后，调用该方法处理
     * @param ctx
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        Channel incoming = ctx.channel();
        System.out.println("客户端：" + incoming.remoteAddress() + "加入");
        //通知已经连接上的所有客户端，不包括当前加入的客户端
        for (Channel channel : channels) {
            channel.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 加入\n");
        }
        channels.add(ctx.channel());
    }

    /**
     * channelInactive后，调用该方法
     * @param ctx
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        Channel incoming = ctx.channel();
        System.out.println("客户端：" + incoming.remoteAddress() + "离开");
        for (Channel channel : channels) {
            channel.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 离开\n");
        }
        channels.remove(ctx.channel());
    }


    /**
     * 调用handlerAdded后调用该方法，表示该客户端在线
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Channel incoming = ctx.channel();
        System.out.println("客户端：" + incoming.remoteAddress() + "在线");
    }

    /**
     * 当服务端关闭和某个客户端的通道后Channel.close()，调用该方法
     * @param ctx
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        Channel incoming = ctx.channel();
        System.out.println("客户端：" + incoming.remoteAddress() + "掉线");
    }


    /**
     * 当服务端收到消息后，调用该方法
     * @param ctx
     * @param msg
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) {
        Channel incoming = ctx.channel();
        System.out.println("客户端：" + incoming.remoteAddress() + "发来了消息");
        for (Channel channel : channels) {
            if (channel != incoming){
                System.out.println("[" + incoming.remoteAddress() + "]发来消息： " + msg);
                channel.writeAndFlush("[" + incoming.remoteAddress() + "]发来消息： " + msg + "\n");
            } else {
                System.out.println("server回复：我收到你发的消息 " + msg);
                channel.writeAndFlush("server回复：我收到你发的消息  " + msg + "\n");
            }
        }
    }

    /**
     * 当某客户端发生异常后，调用该方法
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Channel incoming = ctx.channel();
        System.out.println("客户端：" + incoming.remoteAddress() + "异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
