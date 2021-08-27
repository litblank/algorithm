package com.litblank.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 *
 * 抄自ThreadPoolExecutor中的worker线程
 *
 *
 * 研究 AQS 独占锁
 *
 */
public class AQS extends AbstractQueuedSynchronizer implements Runnable{


    Runnable firstTask;

    volatile long completedTasks;

    AQS(Runnable firstTask) {
        setState(-1); // inhibit interrupts until runWorker
        this.firstTask = firstTask;
    }

    public void run() {
//        runWorker(this);
    }


    protected boolean isHeldExclusively() {
        return getState() != 0;
    }

    protected boolean tryAcquire(int unused) {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    protected boolean tryRelease(int unused) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    public void lock()        { acquire(1); }
    public boolean tryLock()  { return tryAcquire(1); }
    public void unlock()      { release(1); }
    public boolean isLocked() { return isHeldExclusively(); }

    void interruptIfStarted() {
//        Thread t;
//        if (getState() >= 0 && (t =) != null && !t.isInterrupted()) {
//            try {
//                t.interrupt();
//            } catch (SecurityException ignore) {
//            }
//        }
    }

}
