package com.lxyz.attackjava.multithreading;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lbf
 * @date 2021/3/29
 */
public class VolatileTest {


    public static volatile int race = 0;
    public static final int THREAD_COUNT = 20;

   /* private static AtomicInteger race = new AtomicInteger(0);*/

    public synchronized static void increase() {
        race++;
//        race.incrementAndGet();
        System.out.println(ClassLayout.parseInstance(race).toPrintable());
    }

    public static volatile boolean shutdown;

    public static void shutdown() {
        shutdown = true;
    }




    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            while (!shutdown) {
                System.out.println("doing something ...");
            }
        });

        Thread t2 = new Thread(() -> {
            shutdown();
        });

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {

            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });

            threads[i].start();

        }
        System.out.println(ClassLayout.parseInstance(race).toPrintable());
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(ClassLayout.parseInstance(race).toPrintable());
        System.out.println("total num is " + race);

//        t1.start();
//        Thread.sleep(2000);
//        t2.start();


    }



}
