package me.code41.algorithm.basic;

/**
 * Created by liushiyao on 2016/5/13.
 * 直接插入排序
 */
public class InsertSort {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        System.out.println("array:");
        for (int a : array) {
            System.out.print(a + ",");
        }
        System.out.println("\nafter sort:");
        int[] arrayAfterSort = sort(array);
        for (int a : arrayAfterSort) {
            System.out.print(a + ",");
        }
    }
}
