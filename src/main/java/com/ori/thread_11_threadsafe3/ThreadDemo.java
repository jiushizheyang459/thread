package com.ori.thread_11_threadsafe3;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setName("窗口1");
        t2.setName("窗口1");
        t3.setName("窗口1");

        t1.start();
        t2.start();
        t3.start();
    }
}