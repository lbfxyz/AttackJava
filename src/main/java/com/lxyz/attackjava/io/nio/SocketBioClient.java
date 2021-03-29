package com.lxyz.attackjava.io.nio;

import cn.hutool.core.thread.NamedThreadFactory;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @author lbf
 * @date 2021/3/20
 */
public class SocketBioClient {


    private static ExecutorService service = new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new NamedThreadFactory("socket-bio-test", false));


    public static void main(String[] args) {


        for (int i = 0; i < 20; i++) {
//            service.submit(() -> {
            try (SocketChannel socketChannel = SocketChannel.open()) {
                socketChannel.configureBlocking(false);
                socketChannel.connect(new InetSocketAddress("192.168.200.1", 7002));

                while (!socketChannel.finishConnect()) {
                    String testData = Thread.currentThread().getName() + ": This is a test data, timestamp is " + System.currentTimeMillis();
                    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
                    byteBuffer.clear();
                    byteBuffer.put(testData.getBytes());

                    byteBuffer.flip();

                    socketChannel.write(byteBuffer);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

//            });
        }
    }
}
