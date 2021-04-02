package com.lxyz.multithreading.base;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lbf
 * @date 2021/3/29
 */
public class CountDownLatchTest {



    public static void main(String[] args) throws Exception{

        int threadCount = 5;
        CountDownLatch doneSignal = new CountDownLatch(threadCount);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {

            executorService.execute(new WorkRunnable(doneSignal, i));

        }
        System.out.println("我已经到达这里了");
        doneSignal.await();
        System.out.println("Done time ---> " + System.currentTimeMillis());

    }

}

class WorkRunnable implements Runnable {

    private CountDownLatch doneSignal;
    private int index;


    public WorkRunnable(CountDownLatch doneSignal, int index) {
        this.doneSignal = doneSignal;
        this.index = index;
    }

    @Override
    public void run() {
        Random random = new Random();
        int num = random.nextInt(10);
        try {
            Thread.sleep(num * 100);
            System.out.println("第" + index + "个线程， " + Thread.currentThread().getName() + " -->" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            doneSignal.countDown();
        }
    }
}

