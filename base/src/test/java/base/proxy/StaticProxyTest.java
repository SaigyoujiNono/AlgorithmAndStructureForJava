package base.proxy;

import org.junit.Test;

/**
 * 静态代理类测试
 */

public class StaticProxyTest {

    @Test
    public void test1(){
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }

}
