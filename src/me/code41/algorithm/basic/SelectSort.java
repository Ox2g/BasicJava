package me.code41.algorithm.basic;

/**
 * Created by liushiyao on 2016/5/13.
 */
public class SelectSort {
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            int position = i;
            int temp = array[i];
            for (; j < array.length; j++) {
                if (array[j] < temp) {
                    position = j;
                    temp = array[j];
                }
            }
            array[position] = array[i];
            array[i] = temp;
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
