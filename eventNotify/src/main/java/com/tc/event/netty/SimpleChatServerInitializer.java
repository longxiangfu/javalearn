package com.tc.event.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 服务端初始化
 */
public class SimpleChatServerInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * 初始化Channel
     * @param socketChannel
     */
    @Override
    protected void initChannel(SocketChannel socketChannel){
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());
        //事件处理
        pipeline.addLast("handler", new SimpleChatServerHandler());
    }
}
