package com.ori.thread_14_threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
    /**
     * 单个线程被创建，会在执行后立即销毁
     */
   /* List<Thread> threadList = new ArrayList<>();
    void execute(Runnable command) {
        Thread thread = new Thread(command);
        threadList.add(thread);
        thread.start();
    }*/

    /**
     * 有bug
     * 如果commandList为空
     * 会一直消耗cpu
     */
    /*List<Runnable> commandList = new ArrayList<>();

    Thread thread = new Thread(() -> {
        while (true) {
            if (!commandList.isEmpty()) {
                Runnable command = commandList.remove(0);
                command.run();
            }
        }
    });

    void execute(Runnable command) {
        commandList.add(command);
    }*/

    /**
     * 使用阻塞队列
     */
    BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(1024);

    private final Runnable task = () -> {
        while (true) {
            try {
                Runnable command = blockingQueue.take();
                command.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    Thread thread = new Thread(task, "唯一线程");

    {
        thread.start();
    }

    void execute(Runnable command) {
        /*add在阻塞队列满了之后会抛出异常
        offer通过返回值判断是否成功的给阻塞队列添加了元素*/
        boolean offer = blockingQueue.offer(command);
    }
}

