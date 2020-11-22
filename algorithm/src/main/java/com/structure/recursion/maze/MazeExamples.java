package com.structure.recursion.maze;

/**
 * 迷宫问题
 */


public class MazeExamples {
    static private int count = 0;

    public static void main(String[] args) {
        //先创建一个二维数组模拟迷宫
        int[][] map = new int[8][7];
        startMaze(map);
//        map[1][2]=1;
//        map[2][2]=1;
        System.out.println(setWay1(map, 1, 1));
        showMap(map);
        System.out.println(count);
    }

    /**
     * 通过递归查找
     * 如果 小球到达map[6][5]则通路找到
     * 当map[row][col]=0时表示该点没有走过，当为1时表示墙，2表示通路，3表示该点已经走过，但是不通
     * 在走迷宫时需要确定一个策略 下->右->上->左
     *
     * @param map 地图
     * @param row 从哪个位置开始找，行
     * @param col 列
     * @return 找到了为true
     */
    public static boolean setWay(int[][] map, int row, int col) {
        count++;
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[row][col] == 0) {//表示该点还没有走过
                map[row][col] = 2;//假设该点是可以走通的。
                if (setWay(map, row + 1, col)) {
                    System.out.printf("%d-%d\n", row, col);
                    return true;
                } else if (setWay(map, row, col + 1)) {
                    System.out.printf("%d-%d\n", row, col);
                    return true;
                } else if (setWay(map, row - 1, col)) {
                    System.out.printf("%d-%d\n", row, col);
                    return true;
                } else if (setWay(map, row, col - 1)) {
                    System.out.printf("%d-%d\n", row, col);
                    return true;
                } else {
                    //说明该点走不通
                    map[row][col] = 3;
                }
            }
        }
        return false;
    }

    //上->左->下->右
    public static boolean setWay1(int[][] map, int row, int col) {
        count++;
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[row][col] == 0) {//表示该点还没有走过
                map[row][col] = 2;//假设该点是可以走通的。
                if (setWay1(map, row - 1, col)) {
                    System.out.printf("%d-%d\n", row, col);
                    return true;
                } else if (setWay1(map, row, col - 1)) {
                    System.out.printf("%d-%d\n", row, col);
                    return true;
                } else if (setWay1(map, row + 1, col)) {
                    System.out.printf("%d-%d\n", row, col);
                    return true;
                } else if (setWay1(map, row, col + 1)) {
                    System.out.printf("%d-%d\n", row, col);
                    return true;
                } else {
                    //说明该点走不通
                    map[row][col] = 3;
                }
            }
        }
        return false;
    }

    /**
     * 生成地图
     *
     * @param arr 传入的数组
     * @return arr
     */
    static public int[][] startMaze(int[][] arr) {
        //约定是1是墙
        int row = arr.length;
        int column = arr[0].length;

        for (int i = 0; i < row; i++) {
            arr[i][0] = 1;
            arr[i][column - 1] = 1;
        }
        for (int i = 0; i < column; i++) {
            arr[0][i] = 1;
            arr[row - 1][i] = 1;
        }
        for (int i = 0; i < column / 2; i++) {
            arr[row / 2 - 1][i] = 1;
        }
        showMap(arr);
        return arr;
    }

    static public void showMap(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%d ", ints[j]);
            }
            System.out.println();
        }
    }
}
