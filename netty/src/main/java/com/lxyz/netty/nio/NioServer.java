package com.lxyz.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lbf
 * @date 2021/3/15
 */
public class NioServer {


    public static void main(String[] args) {

        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(7010));
            serverSocketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("服务端启动成功。。。");

            while (true) {
                int num = selector.select();
                if (num > 0) {
                    Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeySet.iterator();

                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();

                        if (key.isAcceptable()) {
                            // accept事件
                            // 获取连接的客户端
                            ServerSocketChannel server = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = server.accept();
                            socketChannel.configureBlocking(false);

                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println("客户端连接成功，端口" + socketChannel.socket().getPort());
                        } else if (key.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            int len = socketChannel.read(buffer);
                            if (len > 0) {
                                System.out.println("接收到客户端的消息：" + new String(buffer.array()));
                            } else if (len == -1) {
                                System.out.println("断开连接");
                                socketChannel.close();
                            }
                        }
                        iterator.remove();
                    }
                } else {
                    System.out.println("num is " + num + ", no connect client");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
