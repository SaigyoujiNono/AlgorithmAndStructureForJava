package com.structure.likestack;


public class StackMain {

    public static void main(String[] args) {
        //先创建一个ArrayStack对象
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        stack.pop();
        stack.list();

    }

}
