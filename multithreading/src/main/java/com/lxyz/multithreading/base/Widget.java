package com.lxyz.multithreading.base;

/**
 * @author lbf
 * @date 2021/3/28
 */
public class Widget {

    public synchronized void doSomething() {
        System.out.println("this is parent do something ..");
    }

}
