package com.structure.stack;

public class ArrayStack {
    private int maxSize;    //栈的大小
    private int [] stack;   //数组模拟栈
    private int top = -1;   //栈顶初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return this.top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return this.top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        this.stack[top] = value;
    }

    //出栈
    public int pop() {
        //先判断栈空
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = this.stack[top];
        top--;
        return value;
    }

    //显示栈的情况,遍历时，需要从栈顶开始显示数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top;i >= 0; i--){
            System.out.printf("stack[%d]=%d\n",i,this.stack[i]);
        }
    }

}
