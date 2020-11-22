package com.structure.tree;

/**
 * 定义二叉树
 */
public class BinaryTree {
    private HeroNode root;
    private int nodeCount = 0;

    public void setRoot(HeroNode root) {
        this.root = root;
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
    public HeroNode preOrderFind(int no) {
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
    public HeroNode infixOrderFind(int no) {
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
    public HeroNode postOrderFind(int no) {
        if (this.root != null) {
            return this.root.postOrderFind(no);
        } else {
            System.out.println("当前二叉树为空");
            return null;
        }
    }

    /**
     * 简单删除二叉树节点
     *      1)如果是叶子节点则直接删除叶子节点
     *      2)如果非叶子节点，则删除整个子树，如果删除的是跟节点则清空整个二叉树
     */
    //简单删除节点
    public void simpleDeleteToNo(int no){
        if (this.root.getNo()==no) {
            this.root = null;
            System.out.println("删除的是根节点，清空整个二叉树");
        }else {
            this.root.simpleDeleteNodeToNo(no);
//            this.root.simpleDeleteToNoIter(no);
        }
    }

}
