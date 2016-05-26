package me.code41.cocurrent;

import java.util.concurrent.*;

/**
 * Created by liushiyao on 2016/5/26.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("集齐龙珠，召唤神龙");
            }
        });

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 10000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    long start = System.currentTimeMillis();
                    System.out.println("Thread start.." + Thread.currentThread().getName() + "..." + cyclicBarrier.getNumberWaiting());
                    try {
                        Thread.sleep(1000L * (finalI + 1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int result = 0;
                    try {
                        result = cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread end.." + Thread.currentThread().getName() + "..." + (System.currentTimeMillis() - start) + "ms...." + result);
                }
            });
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
        executor.shutdown();
    }
}
