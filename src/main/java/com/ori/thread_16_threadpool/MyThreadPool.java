package com.ori.thread_16_threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

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

    private final int corePoolSize;
    private final int maxSize;
    private final int timeout;
    private final TimeUnit timeUnit;
    public final BlockingQueue<Runnable> blockingQueue;
    private final RejectHandle rejectHandle;

    public MyThreadPool(int corePoolSize, int maxSize, int timeout, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectHandle rejectHandle) {
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.blockingQueue = blockingQueue;
        this.rejectHandle = rejectHandle;
    }

    //线程池应该有多少个线程
    List<Thread> coreList = new ArrayList<>();

    List<Thread> supportList = new ArrayList<>();

    //判断thread list有多少个元素 如果没到core pool size 那么我们就创建线程
    void execute(Runnable command) {
        if (coreList.size() < corePoolSize) {
            Thread thread = new CoreThread();
            coreList.add(thread);
            thread.start();
        }
        /*add在阻塞队列满了之后会抛出异常
        offer通过返回值判断是否成功的给阻塞队列添加了元素*/
        if (blockingQueue.offer(command)) {
            return;
        }
        if (coreList.size() + supportList.size() < maxSize) {
            Thread thread = new SupportThread();
            supportList.add(thread);
            thread.start();
        }
        if (!blockingQueue.offer(command)) {
            rejectHandle.reject(command, this);
        }
    }

    class CoreThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable command = blockingQueue.take();
                    command.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class SupportThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable command = blockingQueue.poll(timeout, timeUnit);
                    if (command == null) {
                        break;
                    }
                    command.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + "线程结束了！");
        }
    }
}

