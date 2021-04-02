package com.lxyz.netty.netty.base;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author lbf
 * @date 2021/3/25
 */
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("客户端上线， {}", channel.remoteAddress());
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("收到信息客户端{}的消息，【{}】", ctx.channel().remoteAddress(), msg.toString());
        System.err.println("server ctx channel id ----> " + ctx.channel().id());
        ctx.writeAndFlush(msg.toString() + "--" + new Random().nextInt(100));
    }
}
