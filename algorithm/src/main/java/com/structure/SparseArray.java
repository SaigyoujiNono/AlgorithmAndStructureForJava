package com.structure;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) {
        int chessHigh=11;
        int chessWidth=11;
        int chessArr[][] = new int[chessHigh][chessWidth];

        System.out.println(chessArr.length);
        System.out.println(chessArr[0].length);

        chessArr[1][2]=1;
        chessArr[2][3]=2;
        chessArr[5][3]=2;
        chessArr[4][7]=2;
        System.out.println();
        System.out.println(chessArr[0]);
        System.out.println();

        for (int[] row:chessArr){
            for (int chess:row){
                System.out.printf("%d\t",chess);
            }
            System.out.println();
        }
        System.out.println("************************************");
        int count=0;
        for (int i = 0; i < chessHigh ; i++) {
            for (int j = 0; j < chessWidth; j++) {
                if(chessArr[i][j] != 0){
                    count++;
                }
            }
        }
        System.out.println(count);

        /**
         * 创建稀疏数组
         */
        int sparseArr[][] = new int[count+1][3];
        sparseArr[0][0]=chessHigh;
        sparseArr[0][1]=chessWidth;
        sparseArr[0][2]=count;

        int flag=0;
        for (int i = 0; i < chessHigh ; i++) {
            for (int j = 0; j < chessWidth; j++) {
                if(chessArr[i][j] != 0){
                    flag++;
                    sparseArr[flag][0]=i;
                    sparseArr[flag][1]=j;
                    sparseArr[flag][2]=chessArr[i][j];
                }
            }
        }
        for (int[] row:sparseArr){
            for (int chess:row){
                System.out.printf("%d\t",chess);
            }
            System.out.println();
        }

        /**********************************************************/
        FileOutputStream f=null;
        OutputStreamWriter writer = null;
        try {
            f=new FileOutputStream("F:/sparseArr");
            writer = new OutputStreamWriter(f,"UTF-8");
            System.out.println("这里是输出到文件");
            for (int[] row:sparseArr){
                for (int chess:row){
                    writer.append(chess+"\t");
                    System.out.printf("%d\t",chess);
                }
                writer.append("\n");
                System.out.println();
            }


        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /**********************************************************/

        System.out.println();
        System.out.println();
        System.out.println();


        /**
         * 稀疏数组还原二维数组
         */
        int[][] chessArray= new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 0; i < sparseArr[0][2]; i++) {
            chessArray[sparseArr[i+1][0]][sparseArr[i+1][1]]=sparseArr[i+1][2];
        }

        //打印
        for (int[] row:chessArray){
            for (int chess:row){
                System.out.printf("%d\t",chess);
            }
            System.out.println();
        }
    }


}
