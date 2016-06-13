package me.code41.cocurrent;

import java.util.Random;

/**
 * Created by liushiyao on 2016/6/12.
 */
public class ThreadLocalDemo {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.set("123" + Thread.currentThread().getName());
                    System.out.println(threadLocal.get());
                }
            }).start();
        }
    }
}
