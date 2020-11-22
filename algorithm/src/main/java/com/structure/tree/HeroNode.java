package com.structure.tree;


import java.util.Stack;

/**
 * 节点
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;  //左子节点
    private HeroNode right; //右子节点

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
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

    //编写前序查找-no
    public HeroNode preOrderFind(int no) {
        HeroNode temp = null;
        if (this.no == no) {
            return this;
        }
        //递归左子树前序遍历
        if (this.left != null) {
            temp = this.left.preOrderFind(no);
            if (temp != null) {
                return temp;
            }
        }
        //递归右子树前序遍历
        if (this.right != null) {
            temp = this.right.preOrderFind(no);
            if (temp != null) {
                return temp;
            }
        }
        return null;
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

    //编写中序查找-no
    public HeroNode infixOrderFind(int no) {
        //递归左子树前序遍历
        HeroNode temp = null;
        if (this.left != null) {
            temp = this.left.infixOrderFind(no);
            if (temp != null) {
                return temp;
            }
        }
        if (this.no == no) {
            return this;
        }
        //递归右子树前序遍历
        if (this.right != null) {
            temp = this.right.infixOrderFind(no);
            if (temp != null) {
                return temp;
            }
        }
        return null;
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

    //编写后序查找-no
    public HeroNode postOrderFind(int no) {
        //递归左子树前序遍历
        HeroNode temp = null;
        if (this.left != null) {
            temp = this.left.postOrderFind(no);
            if (temp != null) {
                return temp;
            }
        }
        //递归右子树前序遍历
        if (this.right != null) {
            temp = this.right.postOrderFind(no);
            if (temp != null) {
                return temp;
            }
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }


    /**
     * 简单删除二叉树节点
     *      1)如果是叶子节点则直接删除叶子节点
     *      2)如果非叶子节点，则删除整个子树，如果删除的是跟节点则清空整个二叉树
     */
    public void simpleDeleteNodeToNo(int no){
        if (this.left!=null) {
            if (this.left.getNo() == no) {
                this.left=null;
                return;
            }else {
                if (this.left!=null){
                    this.left.simpleDeleteNodeToNo(no);
                }
            }
        }
        if (this.right!=null) {
            if (this.right.getNo() == no) {
                this.right=null;
                return;
            }else {
                if (this.right!=null){
                    this.right.simpleDeleteNodeToNo(no);
                }
            }
        }
    }
    /**
     * 迭代实现简单删除
     * 思路：1、先将根节点压入栈中，然后按前序遍历将每个节点压入栈中，如果匹配正确则弹出，
     *      栈顶即为该节点的父节点，将子节点置空。
     *      2、若该左右节点为叶子节点
     */
    public void simpleDeleteToNoIter(int no){
        Stack<HeroNode> heroStack = new Stack<HeroNode>();
        heroStack.push(this);
        HeroNode temp;
        HeroNode val = null;
        boolean Lflag = false;
        boolean Rflag = false;
        while(true){
            if (heroStack.empty()){
                break;
            }
            temp = heroStack.peek();
            if (temp.left==null && temp.right == null){
                heroStack.pop();
                continue;
            }

            if (temp.right!=null) {
                if (temp.right.getNo() == no) {
                    temp.right = null;
                    break;
                }else {
                    heroStack.push(temp.right);
                }
            }

            if (temp.left!=null){
                if (temp.left.getNo() == no){
                    temp.left = null;
                    break;
                }else {
                    heroStack.push(temp.left);
                }
            }
        }
    }
}
