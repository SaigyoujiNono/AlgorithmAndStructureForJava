package base.reflection;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@MyAnnotation("hi")
public class Human extends Creature<String> implements Comparable<String>,MyInterface {

    private String name;
    public int age;
    public int id;

    public Human() {
    }

    @MyAnnotation("gege")
    private Human(String name) {
        this.name = name;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是");
        return nation;
    }

    public String display(String interests) {
        return "-------------->>>>"+interests;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是人");
    }
}
