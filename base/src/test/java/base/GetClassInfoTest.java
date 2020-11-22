package base;

import base.reflection.Human;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 获取当前运行时类的属性结构
 */
public class GetClassInfoTest {

    /**
     * 拿取运行时类的公有属性和私有属性，没有显示声明public的类无法拿到
     */
    @Test
    public void test1() {
        Class<Human> clazz = Human.class;
        Field[] fields = clazz.getFields();
        for(Field f:fields) {
            System.out.println(f);
        }
        System.out.println("--------------------------------------------------");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f: declaredFields) {
            System.out.println(f);
        }
    }


    /**
     * 运行时类的属性结构
     */
    @Test
    public void test2() {
        Class<Human> clazz = Human.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f: declaredFields) {
            System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
            //权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //数据类型
            Class<?> type = f.getType();
            System.out.println(type.getName());
            //变量名
            String name = f.getName();
            System.out.println(name);
            System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
        }
    }

    /**
     * 获取运行时类的方法
     */
    @Test
    public void test3() {
        Class<Human> clazz = Human.class;
        //获取当前运行时类的public方法
        Method[] methods = clazz.getMethods();
        for (Method m: methods){
            System.out.println(m);
        }
        System.out.println("******************");
        //获取当前运行时类中所有的方法，不包含父类方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m:declaredMethods) {
            System.out.println(m);
        }

    }

    @Test
    public void test4() {
        Class<Human> clazz = Human.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m:declaredMethods) {
            System.out.println("--------------------------");
            Annotation[] annotations = m.getAnnotations();
            //遍历方法上的注解
            for (Annotation a: annotations) {
                System.out.println(a);
            }

            //得到每个方法的权限修饰
            System.out.println(Modifier.toString(m.getModifiers()));

            //返回值类型
            System.out.println(m.getReturnType().getName());

            //方法名
            System.out.println(m.getName());

            //形参列表
            System.out.printf("(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            if(parameterTypes.length > 0) {
                int paraI = 0;
                for (Class p : parameterTypes) {
                    paraI++;
                    if (paraI > parameterTypes.length - 1){
                        System.out.printf(p.getName());
                        break;
                    }
                    System.out.printf(p.getName()+",");
                }
            }
            System.out.printf(")");

            //异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                for (Class e:exceptionTypes) {
                    System.out.print(e.getName()+",");
                }
            }
            System.out.println();

        }
        System.out.println();
        //构造器
        System.out.println("构造器");
        Constructor<?>[] constructor = clazz.getConstructors();
        for (Constructor c : constructor) {
            System.out.println(c);
        }


        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c: declaredConstructors){
            System.out.println(c);
        }

    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void test5() {
        Class<Human> clazz = Human.class;
        //获取父类
        Class<? super Human> superclass = clazz.getSuperclass();
        System.out.println(superclass);
        //获取带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
        //获取带泛型的父类的父类的泛型
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);
    }

    /**
     * 获取运行时类的接口
     */
    @Test
    public void test6() {
        Class<Human> clazz = Human.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class c: interfaces) {
            System.out.println(c);
        }

        System.out.println();
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }
    }

    /**
     * 获取运行时类的包
     */
    @Test
    public void test7() {
        Class<Human> clazz = Human.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /**
     * 获取运行时类的注解
     */
    @Test
    public void test8() {
        Class<Human> clazz = Human.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annos : annotations) {
            System.out.println(annos);
        }
    }

}
