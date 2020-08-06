package test.java.test;

/**
 * @author zhouzh6
 * @date 2020-08-06
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        int x = 66;
//        main.testX(x);
//        System.out.println(x);

//        String s = "66";
//        main.testString(s);
//        System.out.println(s);

        Person p = new Person();
        p.age = 20;
        main.testPerson(p);
        System.out.println(p.getAge());

    }

    public void testX(int x) {
        x = 666;
        System.out.println(x);
    }

    public void testString(String s) {
        s = "666";
    }

    public void testPerson(Person p) {
//        p = new Person();
        p.age = 18;
    }
}
