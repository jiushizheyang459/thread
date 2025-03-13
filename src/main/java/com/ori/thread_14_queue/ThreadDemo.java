package com.ori.thread_14_queue;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    /**
     * 使用阻塞队列完成生产者和消费者的代码
     */
    public static void main(String[] args) {
        //阻塞队列最多只能放一个
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Cook cook = new Cook(queue);
        Foodie foodie = new Foodie(queue);

        cook.start();
        foodie.start();

    }
}
