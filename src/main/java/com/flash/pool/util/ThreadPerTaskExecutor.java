package com.flash.pool.util;

import java.util.concurrent.Executor;

/**
 * 第一版
 * 最简单的线程池工具类
 * @see java.util.concurrent.Executor
 *
 * More typically, tasks are executed in some thread other than the caller's thread.
 * The executor below spawns a new thread for each task.
 * 不是在调用者线程里执行这个任务，新创建一个线程来执行这个任务
 */
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("worker");
        thread.start();
    }

}
