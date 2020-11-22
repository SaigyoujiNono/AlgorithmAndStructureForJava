package com.structure;

/**
 * 插入排序算法
 */
public class InsertSort {

    public static void main(String[] args) {
        int arr[] = {5, 4, 8, 10, 6, 7, 3, 1, 2, 9};
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
