package com.ori.thread_15_demo1;

public class ThreadDemo {
    public static void main(String[] args) {
        /**
         * 一共有1000张票，可以在3个窗口领取，假设每次领取的时间是3000ms
         * 用多线程吗模拟买票过程并打印剩余电影票的数量
         */
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        Thread t3 = new Thread(myRunnable);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
