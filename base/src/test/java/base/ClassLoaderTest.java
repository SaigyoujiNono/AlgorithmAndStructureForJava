package base;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 自定义类加载器
 * 1.引导类加载器
 * 2.扩展类加载器
 * 3.自定义加载器
 */
public class ClassLoaderTest {

    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //无法获取引导类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }

    /**
     * properties用来读取配置文件
     */
    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //读取方式1
//        FileInputStream fis = new FileInputStream("source.properties");
//        pros.load(fis);

        //读取方式2
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("source1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println(user+"------>>"+password);

    }
}
