package com.litblank.thread;

import java.util.concurrent.Semaphore;

public class Semaphore_My {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore=new Semaphore(2);

        semaphore.acquire();
        System.out.println("成功");

        semaphore.acquire();
        System.out.println("成功");

        semaphore.release();
        semaphore.acquire();
        System.out.println("成功");




    }
}
