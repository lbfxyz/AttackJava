package com.lxyz.multithreading.base;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author lbf
 * @date 2021/3/29
 */
public class JOLTest {


    public static void main(String[] args) throws Exception{
        JOLTest jol = new JOLTest();

        System.out.println(ClassLayout.parseInstance(jol).toPrintable());

        Thread.sleep(5000);
//        synchronized (jol) {
            System.out.println(ClassLayout.parseInstance(jol).toPrintable());
//        }

    }


}
