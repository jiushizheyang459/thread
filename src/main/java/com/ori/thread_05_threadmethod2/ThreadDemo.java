package com.ori.thread_05_threadmethod2;

/**
 * 线程的优先级
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr, "飞机");
        Thread t2 = new Thread(mr, "坦克");

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

//        System.out.println(Thread.currentThread().getPriority());
        t1.setPriority(1);
        t1.setPriority(10);

        t1.start();
        t2.start();
    }
}
