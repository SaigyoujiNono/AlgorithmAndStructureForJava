package com.structure;

import java.math.BigInteger;
import java.util.Random;

public class test {

    static int arr[] = {1,1,2,2,3,4,4};

    static char str[]= {'a','b','c','d','e','f','g'};


    static public void rotateString(char[] str, int offset) {
        // write your code here
        char str1[] = new char[str.length - offset];
        char str2[] = new char[offset];

        for (int i = 0; i < str.length - offset; i++) {
            str1[i]= str[i];
        }
        int count = 0;
        for (int i = str.length - offset; i < str.length; i++) {
            if (count<offset){
                str2[count]=str[i];
                count++;
            }
        }
        int count1=0;
        for(char a: str2){
            str[count1]=a;
            count1++;
        }
        for(char b: str2){
            str[count1]=b;
            count1++;
        }


    }
    static public int singleNumber(int[] A) {
        // write your code here
        for(int i=0;i<A.length;i++){
            boolean flag = true;

            for (int j = 0; j < A.length; j++) {
                if(i!=j){
                    if (A[i]==A[j]){
                        flag = false;
                        break;
                    }
                }
            }

            if (flag){
                return A[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(singleNumber(arr));
//        rotateString(str,2);
//        System.out.println(trailingZeros(3125));
//        System.out.println(trailingZeros(625));
//        System.out.println(trailingZeros(125));
//        System.out.println(trailingZeros(25));
//        System.out.println(trailingZeros(5));
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0,j=10; i < 10; i++,j--) {
            System.out.println(random.nextInt(j)+i);
        }
    }
    public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        BigInteger number = new BigInteger("1");
        for (int i = 1;i <= n ;i++ ){
            number = number.multiply(new BigInteger(i+""));
        }
//        System.out.println(number);
//        System.out.println(number.remainder(new BigInteger("1000")).equals(new BigInteger("0")));
        long count = 0;
        while(number.remainder(new BigInteger("10")).equals(new BigInteger("0"))){
            number=number.divide(new BigInteger("10"));
            count++;
        }
        return count;
    }

}
