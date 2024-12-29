package com.ori.thread_13_waitandnotify;

public class Desk {
    //0:没面条 1:有面条
    public static int foodFlag = 0;

    //总个数
    public static int count = 10;

    //锁
    public static Object lock = new Object();
}
