package test.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现了InvocationHandler接口
 *
 * @author zonghan.zhou
 */
public class DynamicSubject implements InvocationHandler {
    /**
     * 这是动态代理的好处，被封装的对象是Object类型，接受任意类型的对象
     */
    private Object obj;

    public DynamicSubject(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling " + method);
        Object invokeRes = method.invoke(obj, args);
        System.out.println("after calling " + method);
        return invokeRes;
    }
}  