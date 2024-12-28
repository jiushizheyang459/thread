package com.ori.thread_08_threadmethod5;

/**
 * 插队线程
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();

        t1.setName("土豆");

        t1.start();

        //表示把t1插入到当前线程之前
        t1.join();

        for (int i = 0; i < 10; i++) {
            System.out.println("main线程" + i);
        }
    }
}
