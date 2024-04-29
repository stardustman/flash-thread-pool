package com.flash.pool;


import com.flash.pool.util.DirectExecutor;

public class DirectExecutorTest {

    public static void main(String[] args) {
        DirectExecutor executor = new DirectExecutor();
        System.out.println("当前线程:" + Thread.currentThread().getName());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程:" + Thread.currentThread().getName());
                System.out.println("直接在调用者的线程执行，😄");
            }
        });
    }
}
