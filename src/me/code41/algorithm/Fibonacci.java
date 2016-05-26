package me.code41.algorithm;

/**
 * 斐波那契数列
 * f(n) = 0 (n=1)
 * f(n) = 1 (n=2)
 * f(n) = f(n-1) + f(n-2)
 * Created by code41 on 2016/5/21.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println(fibonacciWithRecursion(10));
    }

    public static int fibonacci(int n) {
        if (n < 3) return n - 1;
        int fN = 0;
        int fOne = 0;
        int fTwo = 1;
        for (int i = 3; i < n; i++) {
            fN = fOne + fTwo;
            fOne = fTwo;
            fTwo = fN;
        }
        return fN;

    }

    public static int fibonacciWithRecursion(int n) {
        if (n < 3) return n - 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
