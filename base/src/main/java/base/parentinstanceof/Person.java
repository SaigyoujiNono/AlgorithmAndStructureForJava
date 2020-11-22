package base.parentinstanceof;

public class Person {

    private String name;
    private Integer age;
    private String sex;
    private Integer height;
    private Integer weight;

    public Person() {
    }

    public void eat() {
        System.out.println("Person吃东西");
    }

    private void love() {
        System.out.println("恋爱");
    }

    public void drain() {
        System.out.println("Person排泄");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
