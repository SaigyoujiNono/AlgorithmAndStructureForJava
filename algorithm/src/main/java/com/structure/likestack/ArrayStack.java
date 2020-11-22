package com.structure.likestack;



/**
 * 用一个数组表示栈结构
 *
 * @param <T>
 */

public class ArrayStack<T> {

    private int maxSize;    //表示栈的大小
    private T[] stack;  //数组，数组模拟栈，数据放在该组
    private int top = -1;  //top表示栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = (T[]) new Object[this.maxSize];
    }

    /**
     * 判断栈满
     *
     * @return 返回一个boolean值，true为满
     */
    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    /**
     * 判断栈空
     *
     * @return 返回一个boolean，如果为空返回true
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 入栈，先判断栈是否满，然后再放入数据
     *
     * @param t
     */
    public void push(T t) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        this.top++;
        this.stack[top] = t;
    }

    /**
     * 弹出一个数据
     *
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        T value = this.stack[top];
        this.top--;
        return value;
    }

    /**
     * 遍历栈的数据
     */
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

}
