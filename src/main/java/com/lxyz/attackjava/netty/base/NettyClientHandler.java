package com.lxyz.attackjava.netty.base;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author lbf
 * @date 2021/3/25
 */
@Slf4j
public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().id() + "");
        ctx.writeAndFlush("Hello, I'm " + ctx.channel().remoteAddress());
        ctx.fireChannelActive();
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("客户端收到消息， 【{}】", msg.toString());
    }

}
