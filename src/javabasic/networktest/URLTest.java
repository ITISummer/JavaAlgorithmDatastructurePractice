package javabasic.networktest;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL 网络编程
 */
public class URLTest {
    @Test
    public void t1() {
        try {
            URL url = new URL("http://localhost:8080/index.html?username=lvlv");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            // 得到文件路径
            System.out.println(url.getPath());
            // 得到文件名
            System.out.println(url.getFile());
            // 得到查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
