package test.java.util;

import java.util.ArrayList;

public class EnsureCapacityTest {

    public static void main(String[] args) {
        final int N = 100;
        Object obj = new Object();

        // 没用调用ensureCapacity()方法初始化ArrayList对象
        ArrayList list = new ArrayList();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= N; i++) {
            list.add(obj);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("没有调用ensureCapacity()方法所用时间：" + (endTime - startTime) + "ms");

        // 调用ensureCapacity()方法初始化ArrayList对象
        list = new ArrayList(100);
        startTime = System.currentTimeMillis();
        // 预先设置list的大小
        list.ensureCapacity(10);
        for (int i = 0; i <= N; i++) {
            list.add(obj);
        }
        endTime = System.currentTimeMillis();
        System.out.println("调用ensureCapacity()方法所用时间：" + (endTime - startTime) + "ms");
    }


}