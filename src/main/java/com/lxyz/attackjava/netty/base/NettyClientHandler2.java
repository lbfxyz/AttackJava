package com.lxyz.attackjava.netty.base;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Random;

/**
 * @author lbf
 * @date 2021/3/25
 */
public class NettyClientHandler2 extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(",this is random num " + new Random().nextInt(100));
    }
}
