package base;

import base.parentinstanceof.MainClass;
import base.reflection.Person;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * 通过反射创建对应的运行时对象
 */
public class NewInstanceTest {

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person obj = clazz.getDeclaredConstructor().newInstance();

        System.out.println(obj);

    }

    @Test
    public void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {

        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "base.parentinstanceof.MainClass";
                    break;
                case 2:
                    classPath = "base.reflection.Person";
                    break;
                default:
                    break;
            }
            Object obj = getInstance(classPath);
            if (obj instanceof java.util.Date){
                System.out.println("是util-Date吗？");
            }else if(obj instanceof MainClass){
                System.out.println("是MainClass吗？");
            }else if (obj instanceof Person){
                System.out.println("是Person吗？");
            }
        }

    }

    /**
     * 创建一个指定类的对象
     * @param classPath 指定类的全类名
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName(classPath);
        return clazz.getDeclaredConstructor().newInstance();
    }
}
