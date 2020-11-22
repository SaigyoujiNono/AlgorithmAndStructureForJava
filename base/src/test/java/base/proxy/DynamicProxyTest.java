package base.proxy;

import org.junit.Test;

/**
 * 动态代理测试
 */
public class DynamicProxyTest {

    /**
     * 1、根据加载到内存的被代理类，动态的创建一个代理类及其对象
     * 2、当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
     */
    @Test
    public void test1() {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("麻辣烫");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();

    }


}
