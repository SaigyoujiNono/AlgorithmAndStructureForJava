package com.structure;

import com.sortalgorithm.Sort;
import com.sortalgorithm.Util;

/**
 * 给一个数组，将其分成两个数组，使两个数组的和相等
 * 或者判断是否能分开
 */
public class ArrayMatch {
    static private int temp[] = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {
        System.out.println(arrAdd(temp));

        arrAddElement(temp,105);
        arrAddElement(temp,34);
        arrAddElement(temp,40);
    }


    static public int arrAdd(int[] arr) {
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            number += arr[i];
        }
        return number;
    }

    static public void arrAddElement(int[] arr,int val){
        int[] a1 = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            a1[i] = arr[i];
        }
        a1[arr.length] = val;
        Sort.quickSort(a1,0,a1.length-1);
        Util.showIntArray(a1);
        temp = a1;
    }
}
