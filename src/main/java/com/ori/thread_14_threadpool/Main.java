package com.ori.thread_14_threadpool;

public class Main {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool();
        //增加5个任务
        for (int i = 0; i < 5; i++) {
            myThreadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        //主线程不能被阻塞
        System.out.println("主线程没有被阻塞");
    }
}
