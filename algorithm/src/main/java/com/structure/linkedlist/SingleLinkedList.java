package com.structure.linkedlist;

public class SingleLinkedList {
    //先初始化一个头节点，不存放数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    public void add(HeroNode hd) {
        HeroNode temp = this.head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        //当推出while循环时，temp就指向了最后
        temp.setNext(hd);
    }

    /**
     * 根据no编号排序添加
     *
     * @param hd
     */
    public void addByOrder(HeroNode hd) {
        //head不能动，添加一个辅助变量通过遍历搞定
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认false
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > hd.getNo()) {//这里表示如果当前temp的next对象的id大于当前id，则在当前temp后面添加
                break;
            } else if (temp.getNext().getNo() == hd.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();  //后移一位
        }
        if (flag) {
            System.out.println("编号存在！");
        } else {
            hd.setNext(temp.getNext());
            temp.setNext(hd);
        }
    }

    /**
     * 修改单个节点信息
     *
     * @param hd
     */
    public void update(HeroNode hd) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        //根据no编号找到需要修改的节点
        //定义一个辅助变量
        HeroNode temp = head.getNext();
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getNo() == hd.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(hd.getName());
            temp.setNickname(hd.getNickname());
        } else {
            System.out.println("没有找到编号");
        }
    }

    /**
     * 根据no删除单个节点
     *
     * @param hd
     */
    public void delete(HeroNode hd) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == hd.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.setNext(temp.getNext().getNext());
        }
    }

    public void delete(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.setNext(temp.getNext().getNext());
        }
    }

    /**
     * 获取节点长度
     *
     * @param head
     * @return
     */
    public int getLength(HeroNode head) {
        int length = 0;
        HeroNode cur = head.getNext();
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }


    /**
     * 查找单链表倒数第k个节点
     *
     * @param head
     * @param index
     * @return
     */
    public HeroNode getIndexByDesc(HeroNode head, int index) {
        int length = getLength(head);
        for (int i = 0; i < length - index + 1; i++) {
            head = head.getNext();
        }
        return head;
    }

    //显示链表
    public void showLinkList() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = this.head.getNext();
        while (true) {
            System.out.println(temp);
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
    }


    /**
     * 反转链表
     */
    public void reverseLinkedList() {
        HeroNode reverseHead = new HeroNode(0, "", "");
        if (this.head.getNext() == null) {
            return;
        }
        for (int i = 1; i < getLength(this.head) + 1; i++) {
            reverseHead.setNext(getIndexByDesc(this.head, i));
            reverseHead = reverseHead.getNext();
        }
        this.head = reverseHead;
    }

}
