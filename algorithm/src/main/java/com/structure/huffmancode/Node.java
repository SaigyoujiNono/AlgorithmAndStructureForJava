package com.structure.huffmancode;

import lombok.Data;

@Data
public class Node implements Comparable<Node>{
    private Byte val = null;
    private int count;
    private Node left;
    private Node right;

    public Node(byte val, int count) {
        this.val = val;
        this.count = count;
    }

    public Node(int count) {
        this.count = count;
    }

    public Node() {
    }

    //编写前序遍历
    public void preOrder() {
        System.out.println(this);   //先输出父节点
        //递归左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //递归向左子树后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Node{" +
                "count=" + count +
                ", val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大进行排列 从大到小-(this.value - o.value)
        return this.count - o.count;
    }
}
