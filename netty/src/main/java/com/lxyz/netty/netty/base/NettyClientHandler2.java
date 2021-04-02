package com.lxyz.netty.netty.base;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author lbf
 * @date 2021/3/25
 */
@Slf4j
public class NettyClientHandler2 extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().id() + "");
        ctx.writeAndFlush(",this is random num " + new Random().nextInt(100));
    }
}
