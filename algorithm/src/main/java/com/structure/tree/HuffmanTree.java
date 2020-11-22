package com.structure.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 构建一颗huffman树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {5,9,18,25,29,35,45,54,64,84,111}; //
        createHuffmanTree(arr);
        Node val = createHuffmanTree(arr);
        val.infixOrder();
    }


    /**
     * 创建一个huffman树
     * @param arr   传入一个数组
     * @return  返回一个根节点
     */
    public static Node createHuffmanTree(int[] arr){
        //为了操作方便
        //遍历arr数组，将数组得每个元素构成一个node
        //将node放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }


        while(nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(leftNode.getValue()+rightNode.getValue());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);

//        //自己实现的
//        Collections.sort(nodes);
//        Node left;
//        Node right;
//        Node root = nodes.get(0);
//        for (int i = 1; i < nodes.size(); i++) {
//            left = root;
//            right = nodes.get(i);
//            root = new Node(left.getValue()+right.getValue());
//            root.setLeft(left);
//            root.setRight(right);
//        }
//        return root;
    }


    /**
     * 创建类节点
     * 为了让node对象持续排序Collections集合排序
     * 让node实现comparable接口
     */
    @Data
    private static class Node implements Comparable<Node>{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
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
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            //表示从小到大进行排列 从大到小-(this.value - o.value)
            return this.value - o.value;
        }
    }

}
