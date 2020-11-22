package com.sortalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search {

    static int count = 0;
    public static void main(String[] args) {
        int arr[] = {1, 7, 9, 11, 45, 25, 14, 78, 29, 5, 88, 101, 27, 255, 36, 87, 24, 17}; //无序序列
//        seqSearch(arr);     //顺寻查找
        Sort.quickSort(arr, 0, arr.length - 1);
        Util.showIntArray(arr);
//        System.out.println(binarySearch2(arr, 0, arr.length - 1, 24));
//        System.out.println(insertValSearch(arr, 0, arr.length - 1, 1));
        System.out.println(fibonacciSearch(arr, 199));
        System.out.println("count: "+count);

    }


    public static void seqSearch(int[] arr) {
        int a = seqSearch(arr, 50);
        if (a > -1) {
            System.out.println("arr[" + a + "] --> " + arr[a]);
        } else {
            System.out.println(">>>没有此元素<<<");
        }
    }

    //顺序查找
    public static int seqSearch(int[] arr, int value) {
        count++;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 二分查找
     *
     * @param arr     数组
     * @param left    左索引
     * @param right   右索引
     * @param findVal 要查找的值
     * @return 找到就返回下标，没有找到就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        count++;
        //使用二分查找的前提是该数组必须是有序的
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (findVal == arr[mid]) {
            return mid;
        } else if (findVal > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return binarySearch(arr, left, mid - 1, findVal);
        }
        return -1;
    }

    /**
     * 二分查找升级
     *
     * @param arr     数组
     * @param left    左索引
     * @param right   右索引
     * @param findVal 要查找的值
     * @return 找到就返回下标，没有找到就返回-1
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        count++;
        List<Integer> list = new ArrayList<Integer>();
        //使用二分查找的前提是该数组必须是有序的
        if (left > right) {
            list.add(-1);
            return list;
        }
        int mid = (left + right) / 2;
        if (findVal == arr[mid]) {
            int l = mid, r = mid;
            while (arr[(--l)] == arr[mid]) {
                list.add(l);
            }
            list.add(mid);
            while (arr[(++r)] == arr[mid]) {
                list.add(r);
            }
            return list;
        } else if (findVal > arr[mid]) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else {
            return binarySearch2(arr, left, mid - 1, findVal);
        }
    }

    /**
     * 插值查找算法
     *
     * @param arr     数组
     * @param left    左索引
     * @param right   右索引
     * @param findVal 要查找的值
     * @return 找到就返回下标，没有找到就返回-1
     */
    public static int insertValSearch(int[] arr, int left, int right, int findVal) {
        count++;
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (findVal == arr[mid]) {
            return mid;
        } else if (findVal > arr[mid]) {
            return insertValSearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return insertValSearch(arr, left, mid - 1, findVal);
        }
        return -1;
    }

    /**
     * 生成一个fibonacci数列
     *
     * @param maxSize 最大长度
     * @return fibonacci数列
     */
    public static int[] fib(int maxSize) {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * fibonacci查找算法（非递归）
     *
     * @param arr     数组
     * @param findVal 要查找的值
     * @return 返回对应下标，没有返回-1
     */
    public static int fibonacciSearch(int[] arr, int findVal) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;   //表示Fibonacci分割数值的下标
        int mid = 0;    //存放mid值
        int f[] = fib(20);  //获取fibonacci数列
        //获取Fibonacci分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }

        //因为f[k]的值可能大于arr的长度，因此我们需要使用Arrays类，构造一个新的数组，，并指向a[]
        //不足的部分用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上需要使用arr数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            count++;
            mid = low + f[k - 1] - 1;
            if (findVal < temp[mid]) {//我们应该继续向数组的左边查找
                high = mid - 1;
                k--;
            } else if (findVal > temp[mid]) {
                low = mid + 1;
                k -= 2;
            }else {
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
