package me.code41.cocurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ThreadPoolExecutor submit demo for callable & runnable
 * callable是可以携带返回值的，可以依据这个进行多线程模型框架的开发
 * Created by liushiyao on 2016/5/26.
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.CallerRunsPolicy());
//        List<Future<RunnableTask>> futureTaskList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            final int finalI = i;
//            futureTaskList.add((Future<RunnableTask>) executor.submit(new RunnableTask(finalI, countDownLatch)));
//        }
        List<Future> futureTaskList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            futureTaskList.add(executor.submit(new CallableTask(finalI, countDownLatch)));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        for (Future future : futureTaskList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

class CallableTask implements Callable<Object> {

    private int sleepTimeUnit;
    private CountDownLatch countDownLatch;

    public CallableTask(int sleepTimeUnit, CountDownLatch countDownLatch) {
        this.sleepTimeUnit = sleepTimeUnit;
        this.countDownLatch = countDownLatch;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("Thread start.." + Thread.currentThread().getName());
        try {
            Thread.sleep(1000L * (sleepTimeUnit + 1));
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread end.." + Thread.currentThread().getName() + "..." + (System.currentTimeMillis() - start) + "ms....");

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(Thread.currentThread().getName() + "..." + i);
        }
        return result;
    }
}

class RunnableTask implements Runnable {

    private int sleepTimeUnit;
    private CountDownLatch countDownLatch;

    public RunnableTask(int sleepTimeUnit, CountDownLatch countDownLatch) {
        this.sleepTimeUnit = sleepTimeUnit;
        this.countDownLatch = countDownLatch;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println("Thread start.." + Thread.currentThread().getName());
        try {
            Thread.sleep(1000L * (sleepTimeUnit + 1));
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread end.." + Thread.currentThread().getName() + "..." + (System.currentTimeMillis() - start) + "ms....");
    }
}