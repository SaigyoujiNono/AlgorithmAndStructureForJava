package com.structure.stack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式计算器
 * 实现小括号
 */

public class PolandNotationCalculator {

    final private static int ADD = 1;
    final private static int SUB = 1;
    final private static int MUL = 2;
    final private static int DIV = 2;
    final private static int POWER = 3;

    public static void main(String[] args) {
        //先定义一个逆波兰表达式
//        String suffixExpression = "30 4 + 5 * 6 -";
        //先将suffixExpression放到ArrayList
        //给ArrayList传递一个方法，遍历 配合栈 完成计算
//        int cal = calculate(getListString(suffixExpression));
//        System.out.println(cal);

        String expression = "40^2-(6*50-34)-(7+18/3)";
        System.out.println(infixToList(expression));
        List<String> ls = infixToSuffix(infixToList(expression));

        System.out.println(calculate(ls));

    }

    /**
     * 将表达式拆分成数组
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(split));
        return list;
    }

    public static int calculate(List<String> ls) {
        //创建给栈，只需要一个栈
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                //pop出两个数并运算，再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num2 - num1;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num2 / num1;
                } else if (item.equals("^")){
                    res = num2;
                    for (int i = 1; i < num1; i++) {
                        res = res*num2;
                    }
                    System.out.println(res);
                }else {
                    throw new RuntimeException("运算符有问题");
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 中缀转后缀表达式思路：
     * 1、初始化两个栈：运算符栈s1和储存中间结果的栈s2
     * 2、从左至右扫描中缀表达式
     * 3、遇到操作数时直接压入s2
     * 4、遇到操作符时，比较其与s1栈顶运算符的优先级：
     * 1)如果s1为空，或优先级比栈顶运算符为左括号"("，则直接将此运算符入栈
     * 2)否则，若优先级比栈顶运算符的高，也将运算符压入s1
     * 3)否则，将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与s1中新的栈顶运算符比较
     * 5、遇到括号时：
     * 1)如果是左括号"("，则直接压入s1
     * 2)如果是右括号")"，则一次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
     * 6、重复步骤2-5，知道表达式最右边
     * 7、将s1中剩余的运算符一次弹出并压入s2
     * 8、依次弹出s2中的元素并输出，结果的倒序即为中缀表达式对应的后缀表达式
     */
    public static List<String> infixToSuffix(List<String> ls) {
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();

        //遍历
        for (String item : ls) {
            //如果是一个数则入栈
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                //当item优先级小于等于s1栈顶优先级
                while (s1.size() != 0 && getPriority(s1.peek()) >= getPriority(item)) {
                    s2.add(s1.pop());
                }
                //while做完后将item压入栈中
                s1.push(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }

    /**
     * 将中缀表达式放入一个ArrayList中
     *
     * @param infixExpression
     * @return
     */
    public static List<String> infixToList(String infixExpression) {
        //定义一个List存放中缀表达式的对应内容
        List<String> infix = new ArrayList<String>();
        int p = 0;  //用于遍历的指针
        String str;
        char c; //每遍历到一个字符，就放入c中

        do {
            if ((c = infixExpression.charAt(p)) < 48 || (c = infixExpression.charAt(p)) > 57) {
                infix.add("" + c);
                p++;
            } else {
                //如果是一位数，需要考虑多位数的问题
                str = "";
                while (p < infixExpression.length() && ((c = infixExpression.charAt(p)) >= 48 && (c = infixExpression.charAt(p)) <= 57)) {
                    str += c;
                    p++;
                }
                infix.add(str);
            }

        } while (p < infixExpression.length());

        return infix;
    }

    public static int getPriority(String operation) {
        int result = 0;
        if (operation.equals("(") || operation.equals(")")) {
            return result;
        }
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            case "^":
                result = POWER;
                break;
            default:
                System.out.println("不存在运算符");
                break;
        }
        return result;
    }

}
