package com.structure.tree;

import lombok.Data;

public class AVLTree {

    public static void main(String[] args) {
        int[] arr = {4,3,6,5,7,8};
        AVLTree at = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            at.add(new Node(arr[i]));
        }
        System.out.println(at.root.height());
        System.out.println(at.root.leftHeight());
        System.out.println(at.root.rightHeight());
    }





    private Node root;

    //查找父节点
    public Node searchNodeParent(Node node){
        return root.searchNodeParent(node);
    }

    //查找节点
    public Node searchNode(Node node){
        return root.searchNode(node);
    }

    /**
     * @param node  传入的节点
     * @return  返回以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        //循环查找左节点，就会找到最小值
        while(target.left  != null){
            target = target.left;
        }
        //此时target指向了最小节点
        delNode(target);
        return node.value;
    }

    //删除节点
    public void delNode(Node node){
        Node targetNode = searchNode(node);
        if (targetNode == null){
            return;
        }
        if (root.left == null && root.right == null){
            root = null;
            return;
        }
        Node parent = searchNodeParent(node);
        //如果要删除的节点是叶子节点
        if (targetNode.left == null && targetNode != null){
            if (parent.left != null && parent.left.value == node.getValue()){
                parent.left = null;
            }else if (parent.right != null && parent.right.value == node.getValue()){
                parent.right = null;
            }
        }else if (targetNode.left != null && targetNode.right != null){
            int minVal = delRightTreeMin(targetNode.getRight());
            targetNode.value = minVal;
        }else {//删除只有一颗子树的节点
            //如果要删除的节点有左子节点
            if (targetNode.left != null){
                if (parent != null){
                    if (parent.left.value == node.value){
                        parent.left = targetNode.left;
                    }else {
                        parent.right = targetNode.left;
                    }
                }else {
                    root = targetNode.left;
                }

            }else {//如果要删除的节点有右子节点
                if (parent != null){
                    if (parent.left.value == node.value){
                        parent.left = targetNode.right;
                    }else {
                        parent.right = targetNode.right;
                    }
                }else {
                    root = targetNode.right;
                }

            }
        }
    }

    //添加节点
    public void add(Node node){
        if (null == root){
            root = node;
        }else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if (null != root){
            root.infixOrder();
        }
    }

    @Data
    private static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value = value;
        }
        public Node(){}

        //返回左子树高度
        public int leftHeight(){
            if (left == null){
                return 0;
            }
            return left.height();
        }

        //返回右子树的高度
        public int rightHeight(){
            if (right == null){
                return 0;
            }
            return right.height();
        }

        //返回当前节点的高度
        public int height(){
            return Math.max(left == null ? 0:left.height(),right == null ? 0:right.height())+1;
        }

        //左旋转
        private void leftRotate(){
            Node newNode = new Node(value);
            newNode.left = left;
            newNode.right = right.left;
            value = right.value;
            right = right.right;
            left = newNode;
        }

        //查找节点
        public Node searchNode(Node node){
            if (node.value == this.value){
                return this;
            }else if (node.value > this.value){
                if(null != this.right){
                    return right.searchNode(node);
                }else{
                    return null;
                }
            }else {
                if (null != this.left){
                    return left.searchNode(node);
                }else {
                    return null;
                }
            }
        }

        //查找节点的父节点
        public Node searchNodeParent(Node node){
            if ((null != this.left && node.value == this.left.value) ||
                    (null != this.right && node.value == this.right.value)){
                return this;
            }else {
                if (node.value < this.value && this.left != null){
                    return this.left.searchNodeParent(node);
                } else if (node.value >= this.value && this.right != null){
                    return this.right.searchNodeParent(node);
                }else {
                    return null;
                }
            }
        }

        //递归添加节点
        public void add(Node node){
            if (null == node){
                return;
            }

            //判断传入节点的值，根据大小判断左右递归
            if (node.value < this.value){
                if (null == this.left){
                    this.left = node;
                }else {
                    this.left.add(node);
                }
            }else if (node.value > this.value){
                if (null == this.right){
                    this.right = node;
                }else {
                    this.right.add(node);
                }
            }else {
                System.out.println("node value equal!");
            }

            //当添加完一个节点后，如果：（右子树的高度-左子树的高度）>1则
            if (rightHeight() - leftHeight() > 1){
                leftRotate();
//                if (right != null && right.rightHeight() < right.leftHeight()){
//                    //先对右子树进行旋转
//                }
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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
