package com.tc.jdk.concurrent.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 自定义lock
 */
public class TulingLock extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        // cas加锁  state=0
        if (compareAndSetState(0, 1)) {
            // 设置当前线程为锁的独占线程
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        // 释放锁
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    public void lock() {
        acquire(1);
    }

    public void unlock() {
        release(1);
    }


}
