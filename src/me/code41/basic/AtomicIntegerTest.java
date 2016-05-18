package me.code41.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liushiyao on 2016/5/18.
 */
public class AtomicIntegerTest {
    public static AtomicInteger race = new AtomicInteger(0);

    public static void increaseRace() {
        race.incrementAndGet();
    }

    public static void increaseByMultiThread() {
        Thread[] threads = new Thread[30];
        for (int i = 0; i < 30; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increaseRace();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }

    public static void main(String[] args) {
        increaseByMultiThread();
    }
}
