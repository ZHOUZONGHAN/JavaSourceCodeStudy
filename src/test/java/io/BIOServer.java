package test.java.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhouzh6
 * @date 2020-09-08
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        // 创建一个线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 创建一个ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动");

        // 监听 等待客户端连接
        while (true) {
            // 没有客户端的时候会阻塞
            Socket socket = serverSocket.accept();
            System.out.println("连接一个客户端");
            // 有客户端连接则创建一个线程
            threadPool.execute(() -> {
                handler(socket);
            });
        }
    }

    public static void handler(Socket socket) {
        try {
            System.out.println("线程信息： id = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
            byte[] message = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true) {
                // 没有数据的时候会阻塞
                int read = inputStream.read(message);
                // read表示读取的数量
                if (read != -1) {
                    System.out.println(new String(message, 0, read));
                    System.out.println("read = " + read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
