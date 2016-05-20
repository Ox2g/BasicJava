package me.code41.basic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by liushiyao on 2016/5/20.
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        List numList = Arrays.asList(1,2,3,4,5,6);
        stack.addAll(numList);
        stack.add(3,100);
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
