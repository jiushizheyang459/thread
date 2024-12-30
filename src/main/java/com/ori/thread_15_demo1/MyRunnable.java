package com.ori.thread_15_demo1;

public class MyRunnable implements Runnable {

    //总票数
    int ticket = 1000;

    //计数
    int i = 0;


    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (ticket > 0) {
                    i ++;
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + i + "张票，还剩"+ ticket + "张票");
                }else break;
            }
        }
    }
}
