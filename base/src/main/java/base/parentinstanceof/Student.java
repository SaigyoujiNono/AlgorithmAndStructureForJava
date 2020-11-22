package base.parentinstanceof;

public class Student extends Person{
    private String schoolName;

    public Student() {
    }

    public void write() {
        System.out.println("Student书写");
    }

    public void examination() {
        System.out.println("Student考试");
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {

        return "Student{" +
                super.toString()+
                "schoolName='" + schoolName + '\'' +
                '}';
    }
}
