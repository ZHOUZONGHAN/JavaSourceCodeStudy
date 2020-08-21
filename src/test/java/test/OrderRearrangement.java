package test.java.test;

/**
 * @author zhouzh6
 * @date 2020-08-13
 */
public class OrderRearrangement {

    private static volatile int a = 0, b = 0;
    private static volatile int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {

//        int i = 0;
//        for (;;){
//            i++;
//            x = 0; y = 0;
//            a = 0; b = 0;
//            Thread thread = new Thread(() -> {
//                a = 1;
//                x = b;
//            });
//            Thread thread1 = new Thread(() -> {
//                b = 1;
//                y = a;
//            });
//            thread.start();
//            thread1.start();
//            thread.join();
//            thread1.join();
//            if (y == 0 && x == 0){
//                System.out.println(i);
//                return;
//            }
//        }


//        while (true) {
//            a = b = 0;
//            x = y = 0;
//
//            Thread t1 = new Thread(() -> {
//                a = 1;
//                x = b;
//            });
//            Thread t2 = new Thread(() -> {
//                b = 2;
//                y = a;
//            });
//
//            t1.start();
//            t2.start();
//
//            if (x != 0 || y != 0) {
//                System.out.println(x + "\t" + y);
//            }
//
//            t1.join();
//            t2.join();
//        }


        while (true) {
            a = b = 0;

            Thread t1 = new Thread(() -> {
                a = 1;
                b = 1;
            });
            Thread t2 = new Thread(() -> {
                if (a != b) {
                    System.out.println("有点意思");
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }
    }
}
