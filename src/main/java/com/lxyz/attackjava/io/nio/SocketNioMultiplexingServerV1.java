package com.lxyz.attackjava.io.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author lbf
 * @date 2021/3/20
 */
public class SocketNioMultiplexingServerV1 {


    private ServerSocketChannel server = null;
    private Selector selector = null;
    private int port = 7003;

    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }






}
