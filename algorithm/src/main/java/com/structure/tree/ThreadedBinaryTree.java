package com.structure.tree;


import com.sortalgorithm.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * 线索二叉树
 */
public class ThreadedBinaryTree {
    private User root;
    private User pre = null;    //在递归进行线索化时，pre总是保留前一个结点

    public static void main(String[] args) {
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        List<User> userList = new ArrayList<>(7);
        //测试中序线索二叉树的功能
        for (int i = 0; i < 7; i++) {
            User user = new User(i, Util.getChineseName());
            userList.add(user);
        }
        threadedBinaryTree.setRoot(userList.get(0));
        threadedBinaryTree.root.setLeft(userList.get(1));
        threadedBinaryTree.root.setRight(userList.get(2));
        User cur = threadedBinaryTree.root.getLeft();
        cur.setLeft(userList.get(3));
        cur.setRight(userList.get(4));
        cur = threadedBinaryTree.root.getRight();
        cur.setLeft(userList.get(5));
        cur.setRight(userList.get(6));
        threadedBinaryTree.threadedNodes(threadedBinaryTree.root);
        System.out.println(userList.get(6).getRight());
        System.out.println(userList.get(3).getLeftType());
        threadedBinaryTree.threadedList();
    }

    public void setRoot(User root) {
        this.root = root;
    }

    //编写对二叉树进行中序线索化的方法
    public void threadedNodes(User user) {
        if (user != null) {
            //先线索化左子树
            threadedNodes(user.getLeft());

            //线索化当前节点
            if (null == user.getLeft()) {
                //让结点的左指针指向前驱节点
                user.setLeft(pre);
                //修改当前节点的左指针的类型
                user.setLeftType(1);
            }
            //后继节点的处理
            if (null != pre && null == pre.getRight()) {
                pre.setRight(user);
                pre.setRightType(1);
            }

            //每处理一个节点后，让当前节点是下一个节点的前驱节点
            pre = user;

            //线索化右子树
            threadedNodes(user.getRight());
        }
    }

    //遍历线索二叉树
    public void threadedList() {
        //定义一个变量，存储当前遍历的节点，从root开始
        //后面随着遍历而变化，当leftType==1时，说明该节点时按照线索化处理后的有效节点
        User userTemp = root;
        while (userTemp != null) {
            while (userTemp.getLeftType() == 0) {
                userTemp = userTemp.getLeft();
            }
            //打印当前这个节点
            System.out.println(userTemp);
            //如果当前节点的右指针 指向的是后继节点，就一直输出
            while (userTemp.getRightType() == 1){
                //获取当前节点的后继节点
                userTemp = userTemp.getRight();
                System.out.println(userTemp);
            }
            //替换这个遍历的节点
            userTemp = userTemp.getRight();
        }
    }


    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    //前序查找
    public User preOrderFind(int no) {
        if (this.root != null) {
            return this.root.preOrderFind(no);
        } else {
            System.out.println("当前二叉树为空");
            return null;
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    //中序查找
    public User infixOrderFind(int no) {
        if (this.root != null) {
            return this.root.infixOrderFind(no);
        } else {
            System.out.println("当前二叉树为空");
            return null;
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空");
        }
    }

    //后序查找
    public User postOrderFind(int no) {
        if (this.root != null) {
            return this.root.postOrderFind(no);
        } else {
            System.out.println("当前二叉树为空");
            return null;
        }
    }

    /**
     * 简单删除二叉树节点
     * 1)如果是叶子节点则直接删除叶子节点
     * 2)如果非叶子节点，则删除整个子树，如果删除的是跟节点则清空整个二叉树
     */
    //简单删除节点
    public void simpleDeleteToNo(int no) {
        if (this.root.getNo() == no) {
            this.root = null;
            System.out.println("删除的是根节点，清空整个二叉树");
        } else {
            this.root.simpleDeleteNodeToNo(no);
//            this.root.simpleDeleteToNoIter(no);
        }
    }
}
