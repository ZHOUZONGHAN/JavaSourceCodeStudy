package test.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouzh6
 * @date 2020-08-01
 */
public class Teset {
    public static void main(String[] args) {
        Zhou zhou = new Zhou();
        zhou.start();
        for (;;) {
            if (zhou.isFlag()) {
                System.out.println("zhouzhouzhou");
            }
        }
    }
}

class Zhou extends Thread {
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void test2() {
        Map<String, List> map = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        test(list);
    }

    public void test(List<? extends Map<String, ?>> list) {
        // list中不能添加非null的值
        list.add(null);
    }
    @Override
    public void run() {

        flag = true;
        try {
            Thread.sleep(5);
            System.out.println("flag=" + flag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("flag=" + flag);
    }
}
