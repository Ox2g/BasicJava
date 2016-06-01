package me.code41.basic;

/**
 * Created by liushiyao on 2016/6/1.
 */
public class Sub {
    public Sub() {
        test();
    }
    public void test() {
        System.out.println("three");
    }
    public static class Child extends Sub {
        private int a = 3;
//        private static int a = 3;

        public void test() {
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        Child child = new Child();
        child.test();
    }
}
