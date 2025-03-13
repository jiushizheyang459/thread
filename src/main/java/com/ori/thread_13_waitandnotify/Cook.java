package com.ori.thread_13_waitandnotify;

public class Cook extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                //如果面还剩0碗就跳出循环
                if (Desk.count == 0) {
                    break;
                } else {
                    //如果桌上没有面条
                    if (Desk.foodFlag == 0){
                        System.out.println("厨师正在做面条");
                        Desk.foodFlag = 1;
                        Desk.lock.notifyAll();
                    }else {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
