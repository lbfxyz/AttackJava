package com.lxyz.netty.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author lbf
 * @date 2021/3/26
 */
public class ZeroCopy {


    public void init() {
//        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer(1024);
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.heapBuffer(1024);

        if (!byteBuf.hasArray()) {
            System.out.println("直接内存");
            int length = byteBuf.readableBytes();

            System.out.println(length);
        } else {


        }

    }


    public static void main(String[] args) {
        ZeroCopy zeroCopy = new ZeroCopy();
        zeroCopy.init();
    }

}
