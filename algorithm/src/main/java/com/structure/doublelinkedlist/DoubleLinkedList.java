package com.structure.doublelinkedlist;

public class DoubleLinkedList<T> {

    public Node<T> head = new Node<>(null, null, null);


    /**
     * 判断是否为空
     *
     * @return true为空
     */
    public boolean isEmpty() {
        if (head.getNext() != null || head.getPre() != null) {
            return false;
        }
        return true;
    }


    /**
     * 添加一个节点到双向链表的最后
     *
     * @param node
     */
    public void addNode(Node<T> node) {
        Node<T> temp = head;
        //如果不为空则跳转下一指针地址
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        //当while循环完成时，指针就指向了最后，然后分别给前一个node的next和后一个node的pre赋值
        temp.setNext(node);
        node.setPre(temp);
    }


    public void update(T t) {
        //判断空
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        Node<T> temp = head.getNext();
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getT().hashCode() == t.hashCode()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setT(t);
        } else {
            System.out.println("没有找到节点");
        }

    }

}
