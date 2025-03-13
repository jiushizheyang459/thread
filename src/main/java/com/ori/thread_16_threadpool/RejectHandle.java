package com.ori.thread_16_threadpool;

public interface RejectHandle {
    void reject(Runnable rejectCommand, MyThreadPool myThreadPool);
}
