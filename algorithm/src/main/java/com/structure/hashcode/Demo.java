package com.structure.hashcode;


import java.util.Random;

public class Demo {
    static int count =0;
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(8);
        Emp emp = null;
        for (int i = 1; i <= 30; i++) {
            emp = new Emp(i,getChineseName());
            hashTable.add(emp);
        }

        emp = hashTable.findEmpById(7);
        if (emp!=null) {
            System.out.println(emp);
        }else {
            System.out.println("不存在");
        }
        hashTable.list();
    }

    static public String getChineseName(){
        Random random = new Random();
        char lastName[] = {'赵','钱','孙','李','周','吴','郑','王','冯','陈','褚','卫','蒋','沈','韩','杨','朱','秦','尤',
                '许','何','吕','施','张','孔','曹','严'};
        char firstName[] = {'嘉','琼','桂','娣','叶','璧','璐','娅','琦','晶','妍','茜','秋','珊','莎','锦','黛','青','倩',
        '婷','姣','婉','涛','昌','进','林','有','坚','和','彪','博','诚'};
        String fullName = ""+lastName[random.nextInt(lastName.length)]+firstName[random.nextInt(firstName.length)];
        return fullName;
    }
}
