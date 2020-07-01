package com.example.demo.sort;

/**
 * 归并排序
 *
 * @author xueyu
 * @date 2020/6/3 20:14
 */
public class MergeSort {
    public static int[] nums = new int[]{72, 6, 57, 88, 60, 42, 83, 73, 48, 85};

    public static void main(String[] args) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] array, int i, int j) {
        if (j - i <= 1) {
            if (array[i] > array[j]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            return;
        }
        int middle = (i + j) / 2;
        sort(array, i, middle);
        sort(array, middle + 1, j);


        int a1 = i;
        int b1 = middle + 1;
        int index = 0;
        int[] sortedArray = new int[j - i + 1];
        while (a1 <= middle && b1 <= j) {
            if (array[a1] <= array[b1]) {
                sortedArray[index] = array[a1];
                a1++;
            } else {
                sortedArray[index] = array[b1];
                b1++;
            }
            index++;
        }
        if (a1 <= middle) {
            for (int m = a1; m <= middle; m++) {
                sortedArray[index++] = array[m];
            }
        } else {
            for (int m = b1; m <= j; m++) {
                sortedArray[index++] = array[m];
            }
        }
        for (int n = i; n <= j; n++) {
            array[n] = sortedArray[n - i];
        }
    }

}
