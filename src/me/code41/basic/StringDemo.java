package me.code41.basic;

/**
 * Created by liushiyao on 2016/5/17.
 */
public class StringDemo {
    public static void main(String[] args) {
        String a = new String("a");
        String b = a.intern();
        String c = "a";
        System.out.println(a==b);
    }
}
