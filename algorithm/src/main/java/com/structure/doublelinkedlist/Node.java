package com.structure.doublelinkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 双向链表的节点
 *
 * @param <T>
 */
@Data
@AllArgsConstructor
public class Node<T> {
    private Node<T> pre;
    private T t;
    private Node<T> next;
}
