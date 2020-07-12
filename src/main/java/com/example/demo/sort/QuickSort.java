package com.example.demo.sort;

/**
 * 快速排序
 * @author xueyu
 * @date 2020/6/3 18:40
 */
public class QuickSort {
    public static int[] nums = new int[]{72, 6, 57, 88, 60, 42, 83, 73, 48, 85};

    public static void main(String[] args) {

        int i = 0;
        int j = nums.length - 1;

        sort(nums, i, j);

    }

    public static void sort(int[] arry, int i, int j) {
        int start = i;
        int end = j;
        int flag = i;
        while (i < j) {
            if (flag == i && arry[flag] > arry[j]) {
                int temp = arry[flag];
                arry[flag] = arry[j];
                arry[j] = temp;
                flag = j;
                i++;
            }else {
                j--;
            }
        }

        if(i != start){
            sort(arry, start, i);
        }

        if(j != end){
            sort(arry, i, end);
        }
    }
}
