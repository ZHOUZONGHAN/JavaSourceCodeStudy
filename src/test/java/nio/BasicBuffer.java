package test.java.nio;

import java.nio.IntBuffer;

/**
 * buffer的使用
 * @author zhouzh6
 * @date 2020-09-08
 */
public class BasicBuffer {
    public static void main(String[] args) {
        // 创建的一个buffer  表示可以存放5个int值
        IntBuffer intBuffer = IntBuffer.allocate(5);

        // 向buffer中存放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        // buffer读数据
        // 存完之后再读，需要调用读写切换的方法
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
