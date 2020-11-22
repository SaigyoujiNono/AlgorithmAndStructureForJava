package com.structure.tree;

import com.sortalgorithm.Util;

import java.util.ArrayList;
import java.util.List;

public class TreeMain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode heroNode;
        List<HeroNode> heroNodeList = new ArrayList<HeroNode>(10);
        for (int i = 0; i < 10; i++) {
            heroNode = new HeroNode(i, Util.getChineseName());
            heroNodeList.add(heroNode);
        }
        HeroNode cur = null;
        HeroNode root = heroNodeList.get(0);
        binaryTree.setRoot(root);
        root.setLeft(heroNodeList.get(1));
        root.setRight(heroNodeList.get(2));
        cur = root.getLeft();
        cur.setLeft(heroNodeList.get(3));
        cur.setRight(heroNodeList.get(4));
        cur = root.getRight();
        cur.setLeft(heroNodeList.get(5));
        cur.setRight(heroNodeList.get(6));
        binaryTree.preOrder();
//        binaryTree.infixOrder();
//        binaryTree.postOrder();
        binaryTree.simpleDeleteToNo(6);
        System.out.println("删除节点后");
        binaryTree.preOrder();
        System.out.println("查找节点");
        HeroNode temp = binaryTree.preOrderFind(5);
        if (temp != null) {
            System.out.println(temp);
        } else {
            System.out.println("没有找到");
        }

    }
}
