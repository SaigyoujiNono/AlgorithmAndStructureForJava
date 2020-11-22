package com.structure;

import java.util.Arrays;

public class ArrayQueueDemo {
    public static void main(String[] args) {
//        ArrayQueue1 aq=new ArrayQueue1(100);
//
//        for (int i = 0; i < 101; i++) {
//            int a= (int) (Math.random()*1000);
//            if (i<10){
//                System.out.println(i+"------>"+a);
//            }
//            if (i==10){
//                System.out.println(aq.getQueue());
//            }
//
//            aq.addQueue( a);
//        }
//
//        aq.showQueue();


    }


    //使用数组模拟队列
    static class ArrayQueue1 {
        private int maxSize;    //表示数组的最大容量
        private int front;  //表示队列头
        private int rear;   //表示队列尾

        private int[] arr;  //存放数据，模拟队列

        public ArrayQueue1(int maxSize) {
            this.maxSize = maxSize;
            this.arr = new int[this.maxSize];
            this.front = -1;
            this.rear = -1;
        }

        //判断队列是否满
        public boolean isFull(){
            return this.rear == this.maxSize -1;
        }

        //判断队列是否为空
        public  boolean isEmpty(){
            return this.rear == this.front;
        }

        //添加一个数据到队列
        public void addQueue(int n){
            if(this.isFull()){
                System.out.println("队列满了，不能加入");
                return;
            }
            this.rear++; //队列尾后移
            this.arr[this.rear]=n;
        }

        //获取队列数据，出队列
        public int getQueue(){
            if(this.isEmpty()){
                throw new RuntimeException("队列为空");
            }
            this.front++;

            int num=this.arr[front];
            this.arr[front]=0;


            return num;
        }

        //展示队列数据
        public void showQueue(){
            if(this.isEmpty()){
                System.out.println("队列为空");
                return;
            }
            int[] resultArr=new int[this.rear-this.front];
            int count=0;
            for (int i = 0; i < this.arr.length; i++) {
                if (this.arr[i]!=0){
                    resultArr[count]=this.arr[i];
                    count++;
                }
            }
            System.out.println(Arrays.toString(resultArr));
        }

        //显示队列的头数据
        public int headQueue(){
            if(this.isEmpty()){
                throw new RuntimeException("队列为空");
            }
            return this.arr[front+1];
        }

    }


}
