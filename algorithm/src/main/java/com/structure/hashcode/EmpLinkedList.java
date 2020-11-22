package com.structure.hashcode;

/**
 * 链表
 */
public class EmpLinkedList {
    //头指针
    private Emp head;

    /**
     * 1、假定，当添加雇员时，id是增长的，即id从小到大
     * 因此直接将雇员添加到链表的最后
     *
     * @param emp 传入一个雇员信息
     */
    public void add(Emp emp) {
        //如果是第一个雇员，直接添加到头节点
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则遍历到尾节点，再添加
        Emp curEmp = head;
        while (curEmp.getNext() != null) {
            curEmp = curEmp.getNext();
        }
        curEmp.setNext(emp);

    }

    /**
     * 遍历链表雇员信息
     */
    public void list(int no) {
        if (head == null) {
            System.out.println(no + "--> 当前链表为空");
            return;
        }
        System.out.println(no + "--> 当前链表信息为:");
        Emp curEmp = head;
        while (true) {
            System.out.println(curEmp);
            if (curEmp.getNext() == null) {
                break;

            }
            curEmp = curEmp.getNext();
        }
    }

    /**
     * 根据id查找雇员
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {
        if (head == null) {
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.getId() == id) {
                return curEmp;
            }
            if (curEmp.getNext() == null) {
                break;
            }
            curEmp = curEmp.getNext();
        }
        return null;
    }
}
