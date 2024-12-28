package com.ori.thread_10_threadsafe2;

public class MyRunnable implements Runnable {

    int ticket = 0;

    @Override
    public void run() {
        while (true) {
            if (method()) break;
        }
    }

    //非静态 this mr对象唯一
    private synchronized boolean method() {
        if (ticket == 100) {
            return true;
        } else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "在卖第" + ticket + "张票");
        }
        return false;
    }
}
