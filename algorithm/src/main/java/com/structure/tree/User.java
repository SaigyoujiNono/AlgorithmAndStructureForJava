package com.structure.tree;

import lombok.Data;

@Data
public class User {
    private int no;
    private String name;
    private User left;  //左子节点
    private User right; //右子节点

    //规定，leftType == 0表示指向的是左子树，如果==1则表示前驱节点
    //规定，rightType == 0表示指向的是右子树，如果==1则表示后继节点
    private int leftType;
    private int rightType;

    public User() {
    }

    public User(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    //编写前序遍历
    public void preOrder() {
        System.out.println(this);   //先输出父节点
        //递归左子树前序遍历
        if (this.left != null && this.getLeftType()!=1) {
            this.left.preOrder();
        }
        //递归右子树前序遍历
        if (this.right != null&& this.getRightType()!=1) {
            this.right.preOrder();
        }
    }

    //编写前序查找-no
    public User preOrderFind(int no) {
        User temp = null;
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
    public User infixOrderFind(int no) {
        //递归左子树前序遍历
        User temp = null;
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
    public User postOrderFind(int no) {
        //递归左子树前序遍历
        User temp = null;
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
}
