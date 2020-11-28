package com.sortalgorithm;

import java.util.Map;
import java.util.Random;

/**
 * 工具类
 */
public class Util {
    static public Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] arr = createArray(1,100);
        shuffle(arr);
        showIntArray(arr);
    }

    //创建一个顺序数组
    public static int[] createArray(int min,int max){
        int[] tempArr = new int[max+1-min];
        for (int i = min,j=0; i < max+1; i++,j++) {
            tempArr[j] = i;
        }
        return tempArr;
    }

    //将一个数组打乱
    public static void shuffle(int[] arr){
        int temp;
        int index;
        for (int i = 0; i < arr.length; i++) {
            index = randomInt(i+1, arr.length-1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
    public static int[] randomArray(int min, int max){
        int[] arr = createArray(min,max);
        shuffle(arr);
        return arr;
    }

    //随机一个不重复数组
    public static int[] randomArray(int min, int max, int len) {
        if (len > (max - min + 1) || max < min) {
            return null;
        }

        int result[] = new int[len];
        int count = 1;

        for (int i = 0; i < result.length; i++) {
            int num = randomInt(min, max);
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                i--;
            } else {
                result[i] = num;
            }
            if (i == count * 500000 - 1) {
                System.out.println(">>>>>>>已经生成了" + count * 500000 + "个数据了！！<<<<<<<");
                count++;
            }
        }

        return result;
    }

    //展示一维数组
    public static void showIntArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
            if (i == arr.length - 1) {
                System.out.print("]");
            }
        }
        System.out.println();
    }

    public static void showByteArray(byte arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
            if (i == arr.length - 1) {
                System.out.print("]");
            }
        }
        System.out.println();
    }

    //生产一个随机数
    public static int randomInt(int min, int max) {
        if (min == max){
            return max;
        }
        if (max < min){
            return 0;
        }
        return random.nextInt(max-min+1)+min;
    }

    //随机生成一个名字
    static public String getChineseName() {
        char lastName[] = {'赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤',
                '许', '何', '吕', '施', '张', '孔', '曹', '严'};
        char firstName[] = {'嘉', '琼', '桂', '娣', '叶', '璧', '璐', '娅', '琦', '晶', '妍', '茜', '秋', '珊', '莎', '锦', '黛', '青', '倩',
                '婷', '姣', '婉', '涛', '昌', '进', '林', '有', '坚', '和', '彪', '博', '诚'};
        String fullName = "" + lastName[random.nextInt(lastName.length)] + firstName[random.nextInt(firstName.length)];
        return fullName;
    }
}
