package com.litblank.thread.ThreadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


/**
 * 线程池运用。
 *
 * 线程队列
 * 拒绝策略
 * 前置方法
 * 后置方法
 *
 *
 * 创建顺序：核心，扔队列等待，小于最大创建，拒绝策略。
 *
 * submit 配合Future获取返回结果，get阻塞当前线程。
 *
 */
public class Thread_Pool {



    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                0,
                5,
                60,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                (Runnable r, ThreadPoolExecutor executor)->{
                    System.out.println(String.format("线程池已满 当前任务：【%s】,当前任务数【%s】，当前已创建线程数：【%s】",r.toString(),executor.getTaskCount(),executor.getActiveCount()));
                }
                ){

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("开始线程"+t.getName());

            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
//                System.out.println("结束线程");
            }
        };

        for (int i = 0; i < 4; i++) {
            int finalI = i;
            Runnable runnable= new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" 执行任务 "+ finalI);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public String toString() {
                    return "第"+finalI+"个任务";
                }
            };
            threadPoolExecutor.execute(runnable);
            System.out.println("当前线程数：{}"+threadPoolExecutor.getPoolSize());
        }

        threadPoolExecutor.shutdown();


    }
}
