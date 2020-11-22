package com.structure;

import java.util.Arrays;

public class StringMatchString {
    static int count1 = 0;
    static int count2 = 0;

    public static void main(String[] args) {
        String string1 = "主角虽然出发了，可是对于异变的源头却毫无头绪，于是决定先跑到山上看看。" +
                "在山上，主角遇到了琪露诺和自称黑幕的蕾迪·霍瓦特洛克，打倒之后却发现天气完全没有变暖。" +
                "主角在迷路的时候无意中来到了迷途之家——橙的地盘，打倒橙之后主角仍然毫无头绪地到处乱转。" +
                "这时候，爱丽丝·玛格特罗伊德登场了，在三番四次的交手之后，爱丽丝给主角指明了方向——天空。" +
                "于是主角一直向上方的天空前进并遇到了春之妖精——莉莉霍瓦特，最终主角到达了幽明结界——冥界的入口前面，" +
                "发现这里一片春意盎然。在打倒了骚灵三姐妹——露娜萨、梅露兰和莉莉卡并强行打破幽明结界之后，" +
                "主角进入了冥界，确定了幻想乡的春天都被收集到冥界了。在白玉楼的阶梯，主角遇到了魂魄妖梦，" +
                "战斗之后妖梦告诉主角，是大小姐命令她去收集春天的。在再次击倒妖梦之后，" +
                "主角终于面对了此次异变的幕后黑手——西行寺幽幽子，" +
                "原来幽幽子是想让从来都不开放的冥界的樱花树——西行妖开放，才让妖梦去把春天都收集回来的。" +
                "在一番漫长的战斗之后，幽幽子被打倒，于是幻想乡迎来的短暂的春天。";
        String string2 = "樱花树——西行妖";

        long time1 = System.currentTimeMillis();
        int n = stringMatch(string1, string2);
        long time2 = System.currentTimeMillis();

        int m = kmpSearch(string1, string2, kmpNext(string2));
        long time3 = System.currentTimeMillis();
        System.out.println("string字符串长度->" + string1.length());
        System.out.println(string2 + " ->所在下标-> " + n + " ->暴力查找耗时" + count1 + "次" + (time2 - time1) + "ms");
        System.out.println(string2 + " ->所在下标-> " + m + " ->kmp查找耗时" + count2 + "次" + (time3 - time2) + "ms");
    }

    /**
     * 传入两个String类型的值判断str1中是否包含str2，如果包含则返回第一次出现的位置，如果不包含则返回-1
     *
     * @param str1
     * @param str2
     * @return
     */
    static public int stringMatch(String str1, String str2) {

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            boolean flag = true;

            if (s2[0] == s1[i]) {
                for (int j = 0; j < s2.length; j++) {
                    if (s2[j] != s1[i + j]) {
                        flag = false;
                    }
                }
                if (flag) {
                    return i;
                }
            }


        }
        return -1;
    }

    /**
     * kmp算法
     *
     * @param str1 源字符串
     * @param str2 需要查找的子串
     * @param next 字串部分匹配表
     * @return
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //kmp算法核心
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * kmp算法思路
     * 用一个next存储部分匹配值
     * 先提取需要查找的字符串的前缀和后缀
     * 前缀∩后缀
     * 例如搜索词ABCDAB
     * 前缀为A,AB,ABC,ABCD,ABCDA
     * 后缀为BCDAB,CDAB,DAB,AB,B
     * 前缀∩后缀=AB 共有元素AB长度为2
     * 则有ABCDAB [0,0,0,0,0,2]
     * 这个方法是求next
     *
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        //创建一个字符串（字串）
        int[] next = new int[dest.length()];

        for (int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j)我们需要从next[j-1]中获取新的j
            //知道发现有dest.charAt(i) == dest.charAt(j)时才退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            //当dest.charAt(i) == dest.charAt(j)满足时j+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
