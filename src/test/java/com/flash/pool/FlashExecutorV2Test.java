package com.flash.pool;

import com.flash.pool.util.FlashExecutorV2;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 **/
public class FlashExecutorV2Test {
    public static void main(String[] args) {
        FlashExecutorV2 executor = new FlashExecutorV2(new ArrayBlockingQueue<>(5));
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
