package javabasic.networktest;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    @Test
    public void t1() {
        try {
            /**
             * 一个 IP 对应的类
             */
            InetAddress inet1 = InetAddress.getByName("192.168.1.0");
            System.out.println(inet1);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
