package com.structure;


public class CircleArrayQueue {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(10);

        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 1000);
            if (i < 10) {
                System.out.println(i + "------>" + a);
            }

            aq.addQueue(a);
        }
        aq.showQueue();

    }

    static class ArrayQueue {
        private int maxSize;    //表示数组的最大容量
        private int front;  //表示队列头
        private int rear;   //表示队列尾

        private int[] arr;  //存放数据，模拟队列

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            this.arr = new int[this.maxSize];
            this.front = 0;
            this.rear = 0;
        }

        //判断队列是否满
        public boolean isFull() {
            return (this.rear + 1) % this.maxSize == this.front;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return this.rear == this.front;
        }

        //添加一个数据到队列
        public void addQueue(int n) {
            if (this.isFull()) {
                System.out.println("队列满了，不能加入");
                return;
            }
            this.arr[this.rear] = n;

            this.rear = (this.rear + 1) % this.maxSize; //队列尾后移
        }

        //获取队列数据，出队列
        public int getQueue() {
            if (this.isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            //这里需要分析出front是指向队列的第一个元素
            //1、先把front保留一个临时变量
            //2、将front后移
            //3、将临时保存的变量返回
            int value = this.arr[this.front];
            this.front = (this.front + 1) % this.maxSize;
            return value;
        }

        //展示队列数据
        public void showQueue() {
            if (this.isEmpty()) {
                System.out.println("队列为空");
                return;
            }
            for (int i = this.front; i < this.front + getSize(); i++) {
                System.out.printf("arr[%d]=====>%d\n", i % this.maxSize, arr[i % this.maxSize]);
            }

        }

        //求出当前队列有效数据的个数
        public int getSize() {
            return (this.rear + this.maxSize - this.front) % this.maxSize;
        }

        //显示队列的头数据
        public int headQueue() {
            if (this.isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            return this.arr[front];
        }

    }


}
