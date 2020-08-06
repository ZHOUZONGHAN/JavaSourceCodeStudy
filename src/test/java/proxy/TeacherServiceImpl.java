package test.java.proxy;

/**
 * @author zhouzh6
 * @date 2020-07-27
 */
public class TeacherServiceImpl implements ITeacherService {

    @Override
    public void teach() {
        System.out.println("teach...");
    }

    @Override
    public String hello(String name) {
        System.out.println("hello..." + name);
        return name;
    }
}
