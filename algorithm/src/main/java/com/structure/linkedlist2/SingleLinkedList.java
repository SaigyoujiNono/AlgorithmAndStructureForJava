package com.structure.linkedlist2;

import java.util.Stack;

/**
 * 链表的实现类
 */

public class SingleLinkedList<T> {
    //定义一个空的节点
    final private LinkedNode<T> head = new LinkedNode<T>();

    /**
     * 添加一个节点
     *
     * @param t 传入任意对象
     * @return 返回一个boolean值，true为插入成功，false为失败
     */
    public void addNode(T t) {
        LinkedNode<T> tempHead = this.head;//设置一个临时头节点拿到该链表头的指针
        //先遍历出尾部节点
        //如果不为空则将指针指向下一个节点
        while (tempHead.getNext() != null) {
            tempHead = tempHead.getNext();
        }
        LinkedNode<T> temp = new LinkedNode<T>();
        temp.setT(t);
        tempHead.setNext(temp);
    }

    /**
     * 获取链表节点的长度
     *
     * @return 返回链表的长度
     */
    public int getLinkedListLength() {
        int length = 0;//设定为0
        LinkedNode<T> temp = this.head;//设置一个临时变量
        while (temp.getNext() != null) {
            length++;//如果不为空则+1，然后指针指向下一个
            temp = temp.getNext();
        }
        return length;
    }

    /**
     * 反向 打印链表
     */
    public void reversePrintf() {
        Stack<LinkedNode<T>> stack = new Stack<LinkedNode<T>>();
        //入栈
        LinkedNode temp = this.head;
        while (temp.getNext() != null) {
            stack.push(temp.getNext());
            temp = temp.getNext();
        }
        //出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop().getT());
        }
    }


    /**
     * 反转链表
     */
    public void reverseLinkedList() {
        if (this.head.getNext() == null || this.head.getNext().getNext() == null) {
            System.out.println("节点只有1个或者为空，直接返回");
            return;
        }
        LinkedNode<T> cur = this.head.getNext();//辅助指针1
        LinkedNode<T> next = null;//指向当前节点的下一个节点
        LinkedNode<T> reverseHead = new LinkedNode<T>();
        //从头遍历原来的链表
        while (cur != null) {
            next = cur.getNext();//先保存当前节点的下一个节点，预留指针
            cur.setNext(reverseHead.getNext());//将cur的下个节点的地址指向re的下个节点地址
            reverseHead.setNext(cur);//将re下个节点的地址指向cur
            cur = next;//将cur的地址指向next
        }
        this.head.setNext(reverseHead.getNext());
    }

    public LinkedNode<T> reverseLinkedList1(LinkedNode<T> next) {
        if (this.head.getNext() == null || this.head.getNext().getNext() == null) {
            System.out.println("节点只有1个或者为空，直接返回");
            return head;
        }
        LinkedNode<T> re = reverseLinkedList1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return re;
    }

    public LinkedNode<T> getNode(int index) {
        if ((index < getLinkedListLength()) && (index >= 0)) {
            LinkedNode<T> temp = this.head;
            for (int i = 0; i < index + 1; i++) {
                temp = temp.getNext();
            }
            return temp;
        } else {
            throw new RuntimeException("下标越界");
        }

    }


    /**
     * 展示链表所有的数据
     */
    public void showLinkedList() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        LinkedNode<T> temp = this.head.getNext();
        while (true) {
            System.out.println(temp.getT());
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }

    }


}
