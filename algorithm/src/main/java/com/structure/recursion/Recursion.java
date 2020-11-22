package com.structure.recursion;

/**
 * 递归
 */

public class Recursion {
    static final public int a = 50;

    public static void main(String[] args) {
        int[] iarr = {1,2,3,4,5};
        int[] jarr = iarr;
        jarr[0] = 5;
        for (int i: iarr){
            System.out.printf("%d\t",i);
        }
        System.out.println();
        for (int i: jarr){
            System.out.printf("%d\t",i);
        }
    }


    public static void test1(int n){
        if (n >2){
            test1(n-1);
        }
        System.out.println(n);
    }
}
