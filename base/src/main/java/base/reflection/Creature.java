package base.reflection;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Creature<T> implements Serializable {
    private char gender;
    private double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }


}
