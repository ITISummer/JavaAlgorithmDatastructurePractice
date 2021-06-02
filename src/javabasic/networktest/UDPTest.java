package javabasic.networktest;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * UDP 网络协议编程
 */
public class UDPTest {
    /**
     * 发送者
     */
    @Test
    public void sender() throws IOException{
        DatagramSocket socket = new DatagramSocket();

        String str = "测试 UDP 协议";
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,1024);
        socket.send(packet);
        socket.close();
    }

    /**
     * 接收者
     */
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(1024);
        byte[] buf = new byte[100];
        DatagramPacket packet = new DatagramPacket(buf,0,buf.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0, packet.getLength()));
        socket.close();
    }
}
