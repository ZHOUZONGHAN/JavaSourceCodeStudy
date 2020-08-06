package test.java.proxy;

/**
 * @author zhouzh6
 * @date 2020-07-27
 */
public class TestProxy {
    public static void main(String[] args) {
        ITeacherService teacherService = new TeacherServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(teacherService);
        ITeacherService instance = (ITeacherService) proxyFactory.getInstance();
        System.out.println("-------------out");
        instance.teach();
        String str = instance.hello("zhou");
        System.out.println(str);
    }
}
