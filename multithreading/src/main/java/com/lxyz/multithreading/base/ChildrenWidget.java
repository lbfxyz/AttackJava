package com.lxyz.multithreading.base;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author lbf
 * @date 2021/3/28
 */
public class ChildrenWidget extends Widget{


    @Override
    public synchronized void doSomething() {
        System.out.println(toString() + " : calling something ...");
        super.doSomething();
    }


    public static void main(String[] args) {
        ChildrenWidget widget = new ChildrenWidget();
        System.out.println(ClassLayout.parseInstance(widget).toPrintable());
        widget.doSomething();
        System.out.println(ClassLayout.parseInstance(widget).toPrintable());
    }
}
