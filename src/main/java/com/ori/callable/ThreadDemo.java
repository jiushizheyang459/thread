package com.ori.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> fk = new FutureTask<>(mc);

        Thread t1 = new Thread(fk);
//        Thread t2 = new Thread(fk);

        t1.start();

        Integer i = fk.get();
        System.out.println(i);
    }
}
