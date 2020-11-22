package com.structure.recursion;

/**
 * 八皇后问题：一个8*8的棋盘，每行摆一个皇后，不能互相攻击，一共有多少种解法
 * 规则：皇后可以直接攻击斜面与十字
 */

public class EightQueen {
    //皇后数量或者棋盘大小max*max
    int max = 12;
    long count = 0;
    //定义数组array，保存皇后放置位置的结果
    int[] array = new int[max];

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        long t1=System.currentTimeMillis();
        eightQueen.check(0);
        long t2=System.currentTimeMillis();
        System.out.println(t2-t1+"ms");
        System.out.println(eightQueen.count);
    }


    /**
     * 编写放置第n个皇后
     *
     * @param n
     */
    private void check(int n) {
        if (n == max) { //皇后全部放好了
            count++;
//            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后n放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) { //不冲突
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = 1;即将第n个皇后，放置在本行的后移的一个位置
        }
    }

    /**
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法将皇后摆放的位置输出
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
