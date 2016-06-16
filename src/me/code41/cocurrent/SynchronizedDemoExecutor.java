package me.code41.cocurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liushiyao on 2016/6/15.
 */
public class SynchronizedDemoExecutor {
    public static void main(String[] args) {
        final SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        final SynchronizedDemo synchronizedDemoCopy = new SynchronizedDemo();
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.countDown();
                    countDownLatch.await();
                    Thread.sleep(3000L);
//                    synchronizedDemo.methodWithoutSync();
                    // 锁修饰方法
//                    synchronizedDemo.syncWithMethod();
                    // 方法内锁
//                    synchronizedDemoCopy.syncInMethod();
                    // class锁
                    synchronized (SynchronizedDemo.class) {
                        System.out.println("class锁copy start...");
                        Thread.sleep(10000L);
                        System.out.println("class锁copy end...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.countDown();
                    countDownLatch.await();
                    // 锁修饰方法
//                    synchronizedDemo.syncWithMethod();
                    // 方法内锁
//                    synchronizedDemo.syncInMethod();
                    // class锁
                    synchronized (SynchronizedDemo.class) {
                        System.out.println("class锁 start...");
                        Thread.sleep(10000L);
                        System.out.println("class锁 end...");
                    }
                    // 实例对象锁
//                    synchronized (synchronizedDemo) {
//                        System.out.println("实例对象锁 start...");
//                        Thread.sleep(10000L);
//                        System.out.println("实例对象锁 end...");
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
