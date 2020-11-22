package com.structure.linkedlist;

import lombok.Data;

@Data
public class HeroNode {
    private int no;
    private String name;
    private String nickname;
    private HeroNode next;


    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public HeroNode() {
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }


}
