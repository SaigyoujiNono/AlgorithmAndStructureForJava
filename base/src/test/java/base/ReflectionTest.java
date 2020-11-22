package base;

import base.reflection.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 */

public class ReflectionTest {

    @Test
    //使用反射对Person进行操作
    public void reflectionTest1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Person p1 = new Person();
        p1.setAge(15);
        p1.setHeight(155);
        p1.setSex("女");
        p1.setWeight(40);
        p1.setName("wdnmd");
        System.out.println(p1.toString());
        //下面使用反射
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class,Integer.class);
        Object obj = cons.newInstance("Tome", 12);
        Person p2 = (Person) obj;
        System.out.println(p2.toString());
        //通过反射调用public的属性
        Field name = clazz.getDeclaredField("name");
        name.set(p2,"Angel");
        System.out.println(p2.toString());
        //调用public方法
        Method eat = clazz.getDeclaredMethod("eat");
        eat.invoke(p2);
    }

    @Test
    //通过反射调用私有属性
    public void reflectionTest2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Person p1 = new Person();
        p1.setAge(15);
        p1.setHeight(155);
        p1.setSex("女");
        p1.setWeight(40);
        p1.setName("wdnmd");
        Class clazz = Person.class;
        Constructor cons = clazz.getDeclaredConstructor(String.class);
        cons.setAccessible(true);
        //私有构造器
        Person p = (Person) cons.newInstance("傻子");
        System.out.println(p.toString());

        //私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"MMMM");
        System.out.println(p.toString());

        //私有方法
        Method love = clazz.getDeclaredMethod("love");
        love.setAccessible(true);
        love.invoke(p);
    }

    /**
     * 获取Class实例
     */
    @Test
    public void getClassTest3() throws ClassNotFoundException {
        //1
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //2
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //3
        Class clazz3 = Class.forName("base.reflection.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz3 == clazz2);

        //4
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class p4 = classLoader.loadClass("base.reflection.Person");
        System.out.println(p4);
        System.out.println(p4 == clazz1);

    }
}
