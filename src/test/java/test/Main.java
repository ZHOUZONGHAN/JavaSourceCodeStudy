package test.java.test;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhouzh6
 * @date 2020-08-06
 */
public class Main {
    public static <T> T[] test(List<T> list) {
        if (list.size() == 0) {
            return (T[]) new Object[0];
        }
        Class<?> aClass = list.get(0).getClass();
        return list.toArray((T[]) Array.newInstance(aClass, 0));
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
