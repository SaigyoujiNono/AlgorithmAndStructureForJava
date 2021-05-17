package com.structure.tree;


import com.structure.CircleArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 红黑树
 * 1、红黑树是通过2-3-4树演化而来的，一个2-3-4树可以对应多个红黑树，
 * 一个红黑树只能对应一个2-3-4树
 * 2、根节点、2节点一定是黑色，3、4节点一定上黑下红
 */
public class RedBlackTree<K extends Comparable<K>,V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RBNode<K,V> root;

    static class TestNode implements Comparable<TestNode>{
        private int n;
        @Override
        public int compareTo(TestNode o) {
            return Integer.compare(n, o.n);
        }

        public TestNode(int n) {
            this.n = n;
        }

        @Override
        public String toString() {
            return ""+n;
        }
    }

    public static void main(String[] args) {
        RedBlackTree<TestNode,String> r = new RedBlackTree<>();

        r.put(new TestNode(10),null);
        r.put(new TestNode(20),null);
        r.put(new TestNode(30),null);
        r.put(new TestNode(40),null);
        r.put(new TestNode(50),null);
        r.put(new TestNode(60),null);
        r.put(new TestNode(70),null);
        r.put(new TestNode(80),null);
        r.put(new TestNode(90),null);
        r.put(new TestNode(100),null);
        r.put(new TestNode(110),null);
        r.put(new TestNode(120),null);
        r.put(new TestNode(45),null);
        r.put(new TestNode(55),null);
        r.put(new TestNode(57),null);
        r.put(new TestNode(58),null);
        r.put(new TestNode(59),null);
        System.out.println(r);
        System.out.println("\033[31m"+r+"\033[38m");
        r.printTree();
    }

    public void printTree(){
        int deep = root.height();
        Queue<RBNode<K,V>> caq1 = new ArrayDeque<>();
        caq1.offer(root);
        while (!caq1.isEmpty()){
            RBNode<K,V> r = (RBNode<K,V>)caq1.poll();
            if (r.color==RED){
                System.out.print("\033[31m"+r.key+"-\t"+"\033[38m");
            }else{
                System.out.print(r.key+"-\t");
            }

            if (r.left!=null){
                caq1.offer(r.left);
            }
            if (r.right!=null){
                caq1.offer(r.right);
            }
        }
    }

    /**
     * 传入的泛型一定要实现比较接口
     * @param <K>
     * @param <V>
     * 并且每个节点都是双向指针
     */
    static class RBNode<K,V>{
        private RBNode<K,V> pre;
        private RBNode<K,V> left;
        private RBNode<K,V> right;
        private boolean color;
        private K key;
        private V value;

        public RBNode(RBNode<K,V> pre, RBNode<K,V> left, RBNode<K,V> right, boolean color, K key, V value) {
            this.pre = pre;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }
        public int height(){
            return Math.max(left == null ? 0:left.height(),right == null ? 0:right.height())+1;
        }
        public RBNode() {
        }

        public RBNode(K key, V value, RBNode<K, V> pre) {
            this.pre = pre;
            this.key = key;
            this.value = value;
            this.color = BLACK;
        }
    }

    /**
     * 左旋转
     * @param ful
     */
    private void leftRotate(RBNode<K,V> ful){
        if (ful != null) {
            RBNode<K,V> temp = ful.right;
            ful.right = temp.left;
            if (temp.left!=null){
                temp.left.pre = ful;
            }
            if (ful.pre==null){
                root = temp;
            }else if (ful.pre.left == ful){
                ful.pre.left = temp;
            }else {
                ful.pre.right = temp;
            }
            temp.pre = ful.pre;
            ful.pre = temp;
            temp.left = ful;
        }
    }

    /**
     * 右旋转
     * @param ful
     */
    private void rightRotate(RBNode<K,V> ful){
        if (ful != null) {
            RBNode<K,V> temp = ful.left;
            ful.left = temp.right;
            if (temp.right!=null){
                temp.right.pre = ful;
            }
            if (ful.pre==null){
                root = temp;
            }else if (ful.pre.right == ful){
                ful.pre.right = temp;
            }else {
                ful.pre.left = temp;
            }
            temp.pre = ful.pre;
            ful.pre = temp;
            temp.right = ful;
        }
    }

    /**
     * 添加节点
     * 1、添加进来的节点一定是红色
     * 2、如果对应2-3-4树第一个节点，则变成黑色
     * 3、如果对应2-3-4树第二个节点，则是红色
     * 4、如果对应2-3-4树第三个节点，则视情况进行左右旋转
     * 5、如果插入4节点，则需要裂变，中间的节点需要变色
     * @param key
     * @param value
     */
    private void put(K key,V value){
        if (key == null){
            throw new NullPointerException();
        }
        RBNode<K,V> t = this.root;
        if(t == null){
            root = new RBNode<K,V>(key,value,null);
            return;
        }
        int cmp;
        //寻找插入位置
        //定义双亲指针
        RBNode<K,V> parent;
        //沿着根节点寻找插入位置
        do {
            parent = t;
            cmp = key.compareTo(t.key);
            if (cmp>0){
                t = t.right;
            }else if (cmp<0){
                t = t.left;
            }else {
                t.value = value;
                return;
            }
        }while (t!=null);
        RBNode<K, V> node = new RBNode<>(key, value, parent);
        node.color = RED;
        //比较大小分析
        if (cmp<0){
            parent.left = node;
        }else {
            parent.right = node;
        }
        adjust(node);

    }

    private void adjust(RBNode<K,V> x){
        while (x!=null&&x!=root&&x.pre.color==RED){
            //x的父节点是爷爷的左孩子
            if (x.pre == x.pre.pre.left){
                //叔叔节点，即爷爷的另一个孩子
                RBNode<K,V> uncle = x.pre.pre.right;
                if (colorOf(uncle) == RED){
                    setColor(x.pre,BLACK);
                    setColor(uncle,BLACK);
                    setColor(x.pre.pre,RED);
                    //爷爷节点递归
                    x = x.pre.pre;
                }else {
                    if (x.pre.right == x){
                        x = x.pre;
                        leftRotate(x);
                    }
                    setColor(x.pre,BLACK);
                    setColor(x.pre.pre,RED);
                    //右旋转
                    rightRotate(x.pre.pre);
                }
            }else{
                //叔叔节点，即爷爷的另一个孩子
                RBNode<K,V> uncle = x.pre.pre.left;
                if (colorOf(uncle) == RED){
                    setColor(x.pre,BLACK);
                    setColor(uncle,BLACK);
                    //爷爷节点递归
                    setColor(x.pre.pre,RED);
                    x = x.pre.pre;
                }else {
                    if (x.pre.left == x){
                        x = x.pre;
                        rightRotate(x);
                    }
                    setColor(x.pre,BLACK);
                    setColor(x.pre.pre,RED);
                    //左旋转
                    leftRotate(x.pre.pre);
                }
            }
        }
        root.color = BLACK;
    }

    private void setColor(RBNode<K,V> node,boolean color){
        if (node!=null){
            node.color = color;
        }
    }

    /**
     * 获取节点颜色
     * @param node
     * @return
     */
    private boolean colorOf(RBNode<K,V> node){
        return node==null?BLACK:node.color;
    }

    /**
     * 获取节点的父节点
     * @param node
     * @return
     */
    private RBNode<K,V> parentOf(RBNode<K,V> node){
        return node.pre!=null?node.pre:null;
    }

    /**
     * 获取节点的左节点
     * @param node
     * @return
     */
    private RBNode<K,V> leftOf(RBNode<K,V> node){
        return node.left!=null?node.left:null;
    }

    /**
     * 获取节点的右节点
     * @param node
     * @return
     */
    private RBNode<K,V> rightOf(RBNode<K,V> node){
        return node.right!=null?node.right:null;
    }
}
