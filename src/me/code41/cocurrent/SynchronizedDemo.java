package me.code41.cocurrent;

/**
 * Created by liushiyao on 2016/6/15.
 */
public class SynchronizedDemo {

    /**
     * 方法内锁
     */
    public void syncInMethod() {
        synchronized (this) {
            System.out.println("syncInMethod.start...");
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("syncInMethod.end...");
        }
    }

    /**
     * 锁修饰方法
     */
    public synchronized void syncWithMethod() {
        System.out.println("syncWithMethod.start...");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("syncWithMethod.end...");
    }

    public void methodWithoutSync() {
        System.out.println("methodWithoutSync.method...");
    }
}
