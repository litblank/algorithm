package com.litblank.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 三个线程实现顺序打印
 * AA
 * BBBB
 * CCCCCC
 *
 *
 * condition实现 AbstractQueuedSynchronizer -> 内部类 ConditionObject 中存储等待唤醒的线程
 *
 */

public class ReentrantLock_Condition {

    private ReentrantLock reentrantLock=new ReentrantLock();
    private Condition cdA = reentrantLock.newCondition();
    private Condition cdB = reentrantLock.newCondition();
    private Condition cdC = reentrantLock.newCondition();
    private static int flag=1;
    private static int turn=1;


    public ReentrantLock getLock() {
        return reentrantLock;
    }

    public static void main(String[] args) {
        ReentrantLock_Condition aqs=new ReentrantLock_Condition();
        while (turn>0) {
            aqs.threadC();
            aqs.threadB();
            aqs.threadA();
            turn--;
        }
    }

    public void threadA() {
        new Thread(()->{
            reentrantLock.lock();
            try {
                while(flag!=1){
                    cdA.await();
                }
                for (int i = 0; i < 2; i++) {
                    System.out.print("A");
                }
                System.out.println("");
                flag=2;
                cdB.signal();
                System.out.println("Asignal");
                Thread.sleep(1000);
            }catch (Exception e){
            }finally {
                reentrantLock.unlock();
            }
        }).start();
    }

    public void threadB() {
        new Thread(()->{
            reentrantLock.lock();
            try {
                while(flag!=2){
                    cdB.await();
                }
                for (int i = 0; i < 4; i++) {
                    System.out.print("B");
                }
                System.out.println("");
                flag=3;
                cdC.signal();
                System.out.println("Bsignal");
            }catch (Exception e){
            }finally {
                reentrantLock.unlock();
            }
        }).start();
    }


    public void threadC() {
        new Thread(()->{
            reentrantLock.lock();
            try {
                while(flag!=3){
                    cdC.await();
                }
                for (int i = 0; i < 6; i++) {
                    System.out.print("C");
                }
                System.out.println("");
                flag=1;
                cdA.signal();
                System.out.println("Csignal");
            }catch (Exception e){
            }finally {
                reentrantLock.unlock();
            }
        }).start();
    }


}
