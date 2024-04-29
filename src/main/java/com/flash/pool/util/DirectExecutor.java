package com.flash.pool.util;

import java.util.concurrent.Executor;

/**
 * In the simplest case, an executor can run the submitted task immediately in the caller's thread
 */
public class DirectExecutor implements Executor {
    public void execute(Runnable r) {
        r.run();
    }
}