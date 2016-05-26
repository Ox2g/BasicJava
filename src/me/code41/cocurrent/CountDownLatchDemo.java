package me.code41.cocurrent;

import java.util.concurrent.*;

/**
 * Created by liushiyao on 2016/5/24.
 */
public class CountDownLatchDemo {
    public static long timeStart = 0L;

    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, blockingQueue, new ThreadPoolExecutor.CallerRunsPolicy());
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        Runnable runnable;
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        long start = System.currentTimeMillis();
                        System.out.println("Thread runnable start...." + Thread.currentThread().getName() + "..." + countDownLatch.getCount());
                        Thread.sleep(5000L * (finalI + 1));
                        countDownLatch.countDown();
                        countDownLatch.await();
                        System.out.println("Thread runnable end...." + Thread.currentThread().getName() + "..." + (System.currentTimeMillis() - start) + "ms");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            System.out.println("for end");
            executor.execute(runnable);
        }
        while (countDownLatch.getCount() != 0) {
            if (timeStart == 0) {
                timeStart = System.currentTimeMillis();
            } else if (System.currentTimeMillis() - timeStart > 10000L) {
                timeStart = System.currentTimeMillis();
                System.out.println("loading...." + countDownLatch.getCount());

            }
        }
        System.out.println("finish");
        executor.shutdown();

    }
}
