package com.structure.hashcode;

/**
 * hash表
 */
public class HashTable {
    public final EmpLinkedList[] empLinkedListsArray;
    private int tableSize;  //表示共有多少条链表

    /**
     * 传入一个int初始化empLinkedListArray
     *
     * @param tableSize
     */
    public HashTable(int tableSize) {
        this.tableSize = tableSize;
        empLinkedListsArray = new EmpLinkedList[this.tableSize];
        //要先初始化每一条链表，不然会报空指针
        for (int i = 0; i < tableSize; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     *
     * @param emp
     */
    public void add(Emp emp) {
        //根据员工的id，得到该员工应该添加到哪条链表
        int empLinkedListsNO = hashFun(emp.getId());
        empLinkedListsArray[empLinkedListsNO].add(emp);
    }

    /**
     * 遍历所有的链表
     */
    public void list() {
        for (int i = 0; i < tableSize; i++) {
            empLinkedListsArray[i].list(i);
        }
    }

    /**
     * 散列函数，简单取模
     *
     * @param id
     * @return
     */
    public int hashFun(int id) {
        return id % tableSize;
    }

    public Emp findEmpById(int id){
        return empLinkedListsArray[hashFun(id)].findEmpById(id);
    }
}
