package me.code41.algorithm;

import java.util.Stack;

/**
 * Created by liushiyao on 2016/5/12.
 * LeetCode-344-字符串翻转
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
    public String reverseString(String s) {
        if (null == s || s.length() <= 0) {
            return "";
        }
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public String reverseStringByJava(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        if ("olleh".equals(reverseString.reverseString("hello"))) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
    }
}
