package com.flash.pool;

import com.flash.pool.util.FlashExecutorV3;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 **/
public class FlashExecutorV3Test {
    public static void main(String[] args) {
        FlashExecutorV3 executor = new FlashExecutorV3(2,new ArrayBlockingQueue<>(5));
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

    /**
     parking to wait for  <0x000000076ac34318> 多个线程同一个 blocking queue

     "打工人线程-1" #12 prio=5 os_prio=31 tid=0x00007fc5c1010800 nid=0xa803 waiting on condition [0x0000700006bdf000]
     java.lang.Thread.State: WAITING (parking)
     at sun.misc.Unsafe.park(Native Method)
     - parking to wait for  <0x000000076ac34318> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
     at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
     at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
     at java.util.concurrent.ArrayBlockingQueue.take(ArrayBlockingQueue.java:403)
     at com.flash.pool.util.FlashExecutorV3$Worker.getTask(FlashExecutorV3.java:52)
     at com.flash.pool.util.FlashExecutorV3$Worker.run(FlashExecutorV3.java:43)
     at java.lang.Thread.run(Thread.java:748)

     "打工人线程-0" #11 prio=5 os_prio=31 tid=0x00007fc5bb811000 nid=0x5803 waiting on condition [0x0000700006adc000]
     java.lang.Thread.State: WAITING (parking)
     at sun.misc.Unsafe.park(Native Method)
     - parking to wait for  <0x000000076ac34318> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
     **/
}
