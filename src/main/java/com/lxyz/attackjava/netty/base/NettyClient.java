package com.lxyz.attackjava.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author lbf
 * @date 2021/3/25
 */
@Slf4j
public class NettyClient {


    private String host;
    private int port;

    public NettyClient() {
    }

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }


    public void start() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host, port))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast("encoder", new StringEncoder())
                                .addLast("decoder", new StringDecoder())
                                .addLast(new NettyClientHandler())
                                .addLast(new NettyClientHandler2())
                                ;

                    }
                });

        ChannelFuture future = bootstrap.connect().sync();
        future.channel().closeFuture().sync();
//        ChannelFuture future = bootstrap.connect();
//        future.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) throws Exception {
//                if (future.isSuccess()) {
//                    ByteBuf byteBuf = Unpooled.copiedBuffer("Hello ,I'm a client", Charset.defaultCharset());
//                    Channel channel = future.channel();
//                    channel.writeAndFlush(byteBuf);
//                }
//            }
//        });
    }


    public static void main(String[] args) throws Exception{
        NettyClient client = new NettyClient("localhost", 7020);
        client.start();
    }




}
