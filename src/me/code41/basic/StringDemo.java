package me.code41.basic;

/**
 * Created by liushiyao on 2016/5/17.
 */
public class StringDemo {
    public static void main(String[] args) {
        String a = new String("a");
        String c = "a";
        String b = a.intern();
        // return false
        System.out.println(c == a);
        // return true
        System.out.println(c == b);
        // return false
        System.out.println(a == b);

        Integer intA = 11;
        Integer intB = new Integer(11);
        // return false
        System.out.println(intA == intB);
        // return true
        System.out.println(intA.equals(intB));

        Integer intC = 128;
        Integer intD = 128;
        // return false
        System.out.println(intC == intD);

        Integer intE = 127;
        Integer intF = 127;
        // return true
        System.out.println(intE == intF);

    }
}
