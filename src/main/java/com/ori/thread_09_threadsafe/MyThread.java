package com.ori.thread_09_threadsafe;

public class MyThread extends Thread {

    //表示这个类所有的对象，都共享ticket数据
    static int ticket = 0;

    //锁对象，唯一
//    static Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            //同步代码块
//            synchronized (lock) {
            synchronized (MyThread.class) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (ticket < 100) {
                    ticket ++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票!!!");
                } else {
                    break;
                }
            }
        }
    }
}
