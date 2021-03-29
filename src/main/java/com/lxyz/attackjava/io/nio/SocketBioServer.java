package com.lxyz.attackjava.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lbf
 * @date 2021/3/19
 */
public class SocketBioServer {

    public static void main(String[] args) {

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(7002));
            serverSocketChannel.configureBlocking(false);

            List<SocketChannel> channelList = new ArrayList<>();
            while (true) {
                Thread.sleep(1000);

                SocketChannel channel = serverSocketChannel.accept();

                if (channel == null) {
                    System.out.println("nothing connect .... ");
                } else {
                    channel.configureBlocking(false);
                    int port = channel.socket().getPort();
                    System.out.println("client port --> " + port);
                    channelList.add(channel);
                }

                ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
                for (SocketChannel socketChannel : channelList) {
                    int num = socketChannel.read(byteBuffer);
                    if (num > 0) {
                        byteBuffer.flip();
                        byte[] bytes = new byte[byteBuffer.limit()];
                        // 将缓冲区 byteBuffer 里的内容全部写到byte数组里
                        byteBuffer.get(bytes);

                        String s = new String(bytes);
                        System.out.println(socketChannel.socket().getPort() + " get message : " + s);

                        byteBuffer.clear();
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
