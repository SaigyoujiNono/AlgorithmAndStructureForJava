package com.structure.linkedlist2;

public class LinkedList2Main {
    public static void main(String[] args) {
        User u1 = new User("张三", 18, 177);
        User u2 = new User("李四", 25, 172);
        User u3 = new User("王五", 19, 167);

        SingleLinkedList<User> sl = new SingleLinkedList<User>();
        sl.addNode(u1);
        sl.addNode(u2);
        sl.addNode(u3);
        sl.showLinkedList();
//        System.out.println(sl.getLinkedListLength());
//        System.out.println(sl.getNode(0).getT());
        System.out.println("-------------");
//        sl.reverseLinkedList();
//        sl.showLinkedList();
        sl.reversePrintf();


    }
}
