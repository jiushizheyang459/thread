package com.ori.thread_16_threadpool;

public class ThrowRejectHandle implements RejectHandle
{
    @Override
    public void reject(Runnable rejectCommand, MyThreadPool myThreadPool) {
        throw new RuntimeException("阻塞队列满了！");
    }
}
