package base.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理工厂
 */
public class ProxyFactory {
    public static Object getProxyInstance(Object obj) {

        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),handler);

    }


}
