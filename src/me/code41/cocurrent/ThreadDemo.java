package me.code41.cocurrent;

/**
 * Created by liushiyao on 2016/5/26.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        final Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("a start......." + Thread.currentThread().getId() + "...." + Thread.currentThread().getName());
                    Thread.sleep(10000);
                    System.out.println("a finish.......");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("b start......." + Thread.currentThread().getId() + "...." + Thread.currentThread().getName());
                    a.join();
                    System.out.println("b finish.......");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        a.setName("thread name is a");
        b.start();
        a.start();

    }


}
