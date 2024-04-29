package com.flash.pool;

import com.flash.pool.util.FlashExecutorV4;
import com.flash.pool.util.RejectedExecutionHandler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/**
 *
 **/
public class FlashExecutorV4Test {
    public static void main(String[] args) {
        FlashExecutorV4 executor = new FlashExecutorV4(2, new ArrayBlockingQueue<>(5), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, Executor executor) {
                System.out.println("队列满了，提交任务的线程是: 【" + Thread.currentThread().getName() + "】,拒绝策略啥也不做,😄");
            }
        }, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务的线程是: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
