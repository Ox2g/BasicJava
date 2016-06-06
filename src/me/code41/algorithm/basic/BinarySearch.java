package me.code41.algorithm.basic;

/**
 * Created by liushiyao on 2016/6/6.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 5, 8, 9, 11, 23, 45};
        System.out.println(binarySearch(array, 10));
    }

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (target == array[middle]) {
                return middle;
            } else if (target < array[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
