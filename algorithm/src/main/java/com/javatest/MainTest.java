package com.javatest;

public class MainTest {
    public static void main(String[] args) {
        //测试类的传递
        Human hu = new Human("张三",15,180);
        System.out.println(hu);
        testClass(hu);
        System.out.println(hu);

    }

    static public void testClass(Human h){
        h.setName("李四");
    }
}
