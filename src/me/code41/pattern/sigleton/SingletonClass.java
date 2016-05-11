package me.code41.pattern.sigleton;

/**
 * Created by liushiyao on 2016/5/11.
 */
public class SingletonClass {
    public static SingletonClass getInstance() {
        System.out.println("getInstance");
        return InstanceClass.instance;
    }



    private static class InstanceClass {
        static {
            System.out.println("instanceClass init");
        }
        private final static SingletonClass instance = new SingletonClass();
    }

    private SingletonClass() {
        System.out.println("SingletonClass init");
    }
}