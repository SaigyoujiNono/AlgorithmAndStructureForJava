package com.structure.stack;

/**
 * 使用栈完成一个表达式的结果
 * 思路：1、准备两个栈，一个存放数(numStack)，一个存放运算符(operStack)
 * 2、通过一个index(索引)，遍历表达式，如果发现是一个数字，就直接入数栈
 * 3、如果发现扫描到的事一个符号，就分如下情况
 * 1)如果发现当前的符号栈为空，就直接入栈。
 * 2)如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，
 * 就需要从数栈中pop出两个数，再从符号栈中pop出一个符号进行运算，将得到结果，入数栈，
 * 然后将当前操作符入符号栈。如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈。
 * 4、当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运算
 * 5、最后在数栈只有一个数字，就是表达式的结果。
 */

public class Calculator {
    public static void main(String[] args) {
        String expre = "3000-17*60-115-250/5*6+5000";
        SimulationStack<Integer> stackNum = new SimulationStack<Integer>(20);
        SimulationStack<Integer> stackOper = new SimulationStack<Integer>(20);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        StringBuilder keepNum = new StringBuilder("");
        char ch = ' ';//将每次扫描得到的char保存到ch
        boolean numFlag = false;//如果上一次是数字，则为真
        for (int i = 0; i < expre.length(); i++) {
            if (i > 0 && expre.charAt(i - 1) - '0' >= 0) {
                numFlag = true;
            }
            ch = expre.charAt(i);

            //判断ch是什么
            if (stackOper.isOper(ch)) {
                keepNum.delete(0, keepNum.length());
                numFlag = false;
                //判断是否为空
                if (stackOper.isEmpty()) {
                    //如果为空直接入栈
                    stackOper.push((int) ch);
                } else {
                    //处理
                    //选择和栈顶的符号进行优先级比较
                    if (stackOper.priority(ch) <= stackOper.priority(stackOper.peek())) {
                        //如果当前运算符号优先级小于符号栈栈顶，则进入此条
                        num1 = stackNum.pop();
                        num2 = stackNum.pop();
                        oper = stackOper.pop();
                        if (stackOper.isEmpty()) {
                            res = stackNum.cal(num1, num2, oper);
                        } else {
                            if (stackOper.peek() == '-' && oper == '+') {
                                res = stackNum.cal(num1, num2, '-');
                            } else if (stackOper.peek() == '-' && oper == '-') {
                                res = stackNum.cal(num1, num2, '+');
                            } else if (stackOper.peek() == '/' && oper == '*') {
                                res = stackNum.cal(num1, num2, '/');
                            } else if (stackOper.peek() == '/' && oper == '/') {
                                res = stackNum.cal(num1, num2, '*');
                            } else {
                                res = stackNum.cal(num1, num2, oper);
                            }
                        }
                        stackNum.push(res);
                        stackOper.push((int) ch);
                    } else {
                        //如果当前运算符号优先级大于于符号栈栈顶，则进入此条
                        stackOper.push((int) ch);
                    }
                }
            } else {
                //如果是数据则进入此
                if (numFlag) {
                    int a = stackNum.pop();
                    keepNum.append(ch);
                    stackNum.push(StringToInt(keepNum));
                } else {
                    keepNum.append(ch);
                    stackNum.push(ch - '0');
                }
            }
        }

        while (!stackOper.isEmpty()) {
            num1 = stackNum.pop();
            num2 = stackNum.pop();
            oper = stackOper.pop();
            if (stackOper.isEmpty()) {
                res = stackNum.cal(num1, num2, oper);
            } else {
                if (stackOper.peek() == '-' && oper == '+') {
                    res = stackNum.cal(num1, num2, '-');
                } else if (stackOper.peek() == '-' && oper == '-') {
                    res = stackNum.cal(num1, num2, '+');
                } else if (stackOper.peek() == '/' && oper == '*') {
                    res = stackNum.cal(num1, num2, '/');
                } else if (stackOper.peek() == '/' && oper == '/') {
                    res = stackNum.cal(num1, num2, '*');
                } else {
                    res = stackNum.cal(num1, num2, oper);
                }
            }
            stackNum.push(res);
        }
        System.out.println(stackNum.pop());

    }

    static public int StringToInt(StringBuilder value) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            result = result * 10 + (value.charAt(i) - '0');
        }
        return result;
    }

}
