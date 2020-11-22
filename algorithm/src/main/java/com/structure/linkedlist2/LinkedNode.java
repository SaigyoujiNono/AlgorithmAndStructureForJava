package com.structure.linkedlist2;

import lombok.Data;
import lombok.ToString;

/**
 * 自己实现一个链表的节点设置
 */

@Data
@ToString
public class LinkedNode<T> {

    private T t;//节点
    private LinkedNode<T> next;

    public LinkedNode(T t) {
        this.t = t;
    }

    public LinkedNode(T t, LinkedNode<T> next) {
        this.t = t;
        this.next = next;
    }

    public LinkedNode() {
    }
}
