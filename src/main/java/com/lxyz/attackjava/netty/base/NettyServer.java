package com.lxyz.attackjava.netty.base;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * @author lbf
 * @date 2021/3/25
 */
@Slf4j
public class NettyServer {


    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup(8);


        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast("encoder", new StringEncoder())
                                .addLast("decoder", new StringDecoder())
                                .addLast(new NettyServerHandler());
                    }
                });

        ChannelFuture future = serverBootstrap.bind(7020).sync();
        if (future.isSuccess()) {
            log.info("服务端启动成功");
        } else {
            log.info("服务端启动出问题了");
        }
        future.channel().closeFuture().sync();
    }

}
