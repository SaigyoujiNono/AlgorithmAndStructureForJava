package base.parentinstanceof;

public class MainClass {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setSchoolName("傻逼学校");
        student1.setName("学生");
        student1.setAge(15);
        student1.setHeight(165);
        student1.setSex("男");
        student1.setWeight(50);
        student1.eat();
        student1.drain();
        student1.write();
        student1.examination();
        System.out.println(student1.toString());

        BigStudent bigStudent = new BigStudent();
        bigStudent.setSchoolName("傻逼2学校");
        bigStudent.setName("big学生");
        bigStudent.setAge(20);
        bigStudent.setHeight(175);
        bigStudent.setSex("男");
        bigStudent.setWeight(60);
        bigStudent.setEntranceExamScore(155);
        bigStudent.setSchoolCity("南宁");
        bigStudent.doLove();
        System.out.println(bigStudent.toString());
        System.out.println();

    }
}
