package com.ori.thread_07_threadmethod4;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName() + "@" + i);

            //表示出让当前cpu的执行权
            Thread.yield();
        }
    }
}
