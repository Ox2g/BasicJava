package me.code41.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liushiyao on 2016/5/11.
 */
public class HashMapDemo {
    private final static boolean flag = true;

    public static void main(String[] args) {
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }

        syntacticSugarDemo();

        boxAndUnbox();
    }

    /**
     * Java语法糖相关实现，通过反编译class可以对比区别
     * <br>1. 泛型实现</br>
     * <br>2. 自动装箱&自动拆箱</br>
     * <br>3. 遍历循环</br>
     * <br>4. 变长参数</br>
     */
    private static void syntacticSugarDemo() {
        // 擦除法实现的伪泛型
        HashMap<String, String> map = new HashMap<>();
        map.put("test", "hello world");
        System.out.println(map.get("test"));

        Long a = 18L;// 包装类自动装箱

        List<Integer> list = Arrays.asList(1, 2, 3, 4);// 变长参数 & 包装类自动装箱

        // 循环遍历自动转换为迭代器 & 包装类自动拆箱
        for (int i : list) {
            System.out.println(i);
        }

        System.out.println(a);
    }

    private static void boxAndUnbox() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println("====================");
    }
}
