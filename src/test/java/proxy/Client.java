package test.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
  
    public static void main(String[] args) throws Throwable {
        // TODO Auto-generated method stub  

        Subject rs = new RealSubject();//这里指定被代理类
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();

        //生成代理类  ，注意subject是Proxy的子类并且实现了Subject接口的一个类。

        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
        subject.request();
    }
}