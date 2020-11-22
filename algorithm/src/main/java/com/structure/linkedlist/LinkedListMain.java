package com.structure.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1,"宋江","及时雨");
        HeroNode h2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode h3 = new HeroNode(3,"吴用","智多星");

        HeroNode h4 = new HeroNode(3,"张飞","智多星");

        SingleLinkedList sl = new SingleLinkedList();
        sl.addByOrder(h1);
        sl.addByOrder(h3);
        sl.addByOrder(h2);

        System.out.println(sl.getIndexByDesc(sl.getHead(),3));

        System.out.println(sl.getLength(sl.getHead()));

        sl.showLinkList();
        System.out.println("************************");
        sl.update(h4);

        System.out.println(sl.getLength(sl.getHead()));
        sl.showLinkList();
        System.out.println("************************");
//        sl.delete(3);
//        sl.delete(1);

        System.out.println(sl.getLength(sl.getHead()));
        sl.showLinkList();

        System.out.println("000000000");
        sl.reverseLinkedList();
        sl.showLinkList();

    }



}
