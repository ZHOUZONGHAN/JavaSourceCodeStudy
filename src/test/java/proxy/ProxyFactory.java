package test.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhouzh6
 * @date 2020-07-27
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance() {
        System.out.println("------in----");
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            Subject subject = new RealSubject();
            subject.request();
            Object res = method.invoke(target, args);
            return res;
        });
    }

}
