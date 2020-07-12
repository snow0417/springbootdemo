package com.example.demo.sort;

/**
 * 选择排序
 */
public class SelectSort {

    public static int[] arr = new int[]{2, 1, 50, 14, 7, 66, 23, 77, 1, 5, 44, 100, 37};

    public static void main(String[] args) {
        int now = 0;
        while (now < arr.length) {
            int min = now;
            for (int i = now; i < arr.length; i++) {
                if (arr[min] > arr[i]) {
                    min = i;
                }
            }

            int temp = arr[now];
            arr[now] = arr[min];
            arr[min] = temp;

            now++;
        }
        System.out.println(arr);
    }
}
