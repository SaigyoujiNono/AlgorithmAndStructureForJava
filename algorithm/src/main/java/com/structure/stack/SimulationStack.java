package com.structure.stack;


public class SimulationStack<T> {
    private int maxSize;
    private Object[] stack;
    private int top = -1;

    //构造函数
    public SimulationStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Object[this.maxSize];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public void push(T t){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = t;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        T temp = (T)stack[top];
        top--;
        return temp;
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        return (T)stack[top];
    }

    /**
     * 返回运算符的优先级，数字越大优先级越高
     * @param oper
     * @return
     */
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 判断是不是运算符
     * @param val
     * @return
     */
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;

    }


}
