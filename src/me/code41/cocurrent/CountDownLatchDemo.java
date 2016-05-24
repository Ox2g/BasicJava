package me.code41.cocurrent;

import java.util.concurrent.*;

/**
 * Created by liushiyao on 2016/5/24.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,60, TimeUnit.SECONDS,blockingQueue);
        CountDownLatch countDownLatch = new CountDownLatch(5);

    }
}
