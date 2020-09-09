package test.java.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhouzh6
 * @date 2020-08-06
 */
public class Main {
    public static  <T>T[] test(List<T> list) {
        if(list.size()==0){
            return (T[])new Object[0];
        }
        Class<?> aClass = list.get(0).getClass();
        return list.toArray((T[])Array.newInstance(aClass,0));
    }

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
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        // FIXME
        String[] test = test(list);

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
