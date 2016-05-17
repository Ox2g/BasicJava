package me.code41.basic;

/**
 * Created by liushiyao on 2016/5/17.
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    public static volatile boolean flag = false;

    /**
     * volatile关键字变量测试
     */
    public static void addOption4MultiThreads() {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
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

    public static void getVolatile4MultiThreads() {
        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(flag);
                    if (flag) {
                        System.out.println("状态已经更改");
                        break;
                    }
                }
            }
        });
        readThread.start();

        Thread settingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
                    if (i == 9999999) {
                        flag = true;
                        break;
                    }
                }
            }
        });
        settingThread.start();
    }

    public static void main(String[] args) {
//        addOption4MultiThreads();

        getVolatile4MultiThreads();


    }
}
