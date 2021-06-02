package javabasic.networktest;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * TCP 网络编程
 */
public class TCPTest {
    @Test
    public void client() {
        InetAddress inet = null;
        Socket socket = null;
        OutputStream os = null;
        try {

            inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 1024);
            os = socket.getOutputStream();
            os.write("你好，我是客户端！".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        try {

            ss = new ServerSocket(1024);
            socket = ss.accept();
            is = socket.getInputStream();
            // 不建议
//        byte[] buf = new byte[5];
//        int len;
//        while ((len = is.read(buf))!=-1) {
//            String str = new String(buf,0,len);
//            System.out.print(str);
//        }
            baos = new ByteArrayOutputStream();
            byte[] buf = new byte[5];
            int len;
            while ((len = is.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            System.out.println(baos.toString());
            // 获取客户端信息
            System.out.println(socket.getInetAddress().getHostAddress());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
