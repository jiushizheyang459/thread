package com.ori.threadmethod;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * String getName()
         * void setName(String name)
         */
//        MyThread t1 = new MyThread("飞机");
//        MyThread t2 = new MyThread("坦克");
//
//        t1.start();
//        t2.start();

        /**
         * static Thread currentThread()
         */
//        Thread t = Thread.currentThread();
//        String name = t.getName();
//        System.out.println(name);

        /**
         * static void sleep(long time)
         */
        System.out.println("1111111");
        Thread.sleep(5000);
        System.out.println("2222222");
    }
}
