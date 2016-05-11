package me.code41.pattern.sigleton;

/**
 * Created by liushiyao on 2016/5/11.
 */
public class SingletonTest {
    public static void main(String[] args) {
//        SingletonClass singletonClass = new SingletonClass();
         SingletonClass singletonClass = SingletonClass.getInstance();
    }
}
