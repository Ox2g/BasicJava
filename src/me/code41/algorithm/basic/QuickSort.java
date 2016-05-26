package me.code41.algorithm.basic;

/**
 * Created by liushiyao on 2016/5/25.
 */
public class QuickSort {
    public static void quickSort(int[] array) {
        if (array != null) {
            quickSort(array, 0, array.length - 1);
        }
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin >= end || array == null) {
            return;
        }
        int p = partition1(array, begin, end);
        quickSort(array, begin, p - 1);
        quickSort(array, p + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        return 0;
    }

    private static int partition1(int[] array, int begin, int end) {
        int tmp = array[begin];    //数组的第一个作为中轴
        while (begin < end) {
            while (begin < end && array[end] >= tmp) {
                end--;
            }
            array[begin] = array[end];   //比中轴小的记录移到低端
            while (begin < end && array[begin] <= tmp) {
                begin++;
            }
            array[end] = array[begin];   //比中轴大的记录移到高端
        }
        array[begin] = tmp;              //中轴记录到尾
        return begin;
    }

    private static int partition2(int[] array, int beg, int end) {
        int last = array[end];
        int i = beg - 1;
        for (int j = beg; j <= end - 1; j++) {
            if (array[j] <= last) {
                i++;
                if (i != j) {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[i] ^ array[j];
                    array[i] = array[i] ^ array[j];
                }
            }
        }
        if ((i + 1) != end) {
            array[i + 1] = array[i + 1] ^ array[end];
            array[end] = array[i + 1] ^ array[end];
            array[i + 1] = array[i + 1] ^ array[end];
        }
        return i + 1;
    }

    private static int partition3(int[] array, int beg, int end) {
        int first = array[beg];
        int i = beg, j = end;
        while (i < j) {
            while (array[i] <= first && i < end) {
                i++;
            }
            while (array[j] > first && j >= beg) {
                j--;
            }
            if (i < j) {
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
        }
        if (j != beg) {
            array[j] = array[beg] ^ array[j];
            array[beg] = array[beg] ^ array[j];
            array[j] = array[beg] ^ array[j];
        }
        return j;
    }

    public static void main(String[] args) {
//        int i = 10;
//        int j = 39;
//        System.out.println("i:" + i + "------j:" + j);
//        i = i ^ j;
//        j = i ^ j;
//        i = i ^ j;
//        System.out.println("i:" + i + "------j:" + j);
        int a[] = {3, 1, 5, 2, 7};
        quickSort(a);
    }
}
