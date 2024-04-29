package com.flash.pool;

import com.flash.pool.util.ThreadPerTaskExecutor;

/**
 *
 **/
public class ThreadPerTaskExecutorTest {
    public static void main(String[] args) {
        ThreadPerTaskExecutor executor = new ThreadPerTaskExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务的线程是: " + Thread.currentThread().getName());
            }
        });
    }
}
