package base;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainTest {
    @Test
    public void randomTest() {
//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);

        List<String> strings = Arrays.asList("abc","","bc","efg","abcd");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

    }

}
