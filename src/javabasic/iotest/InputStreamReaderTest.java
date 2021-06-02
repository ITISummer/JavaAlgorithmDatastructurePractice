package javabasic.iotest;

import org.junit.Test;

import java.io.*;

/**
 * 转换流：
 * InputStreamReader:将一个字节输入流转换为字符输入流
 * OutputStreamWriter:将一个字符输出流转换为字节输出流
 * <p>
 * 作用：
 * 提供字节流与字符流之间的转换
 */
public class InputStreamReaderTest {
    @Test
    public void t1() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        // 使用系统默认字符集
//        InputStreamReader isr = new InputStreamReader(fis);

        try {
            fis = new FileInputStream("hello.txt");
            // 使用字符集，取决于文件保存时使用的字符集
            isr = new InputStreamReader(fis, "utf-8");
            char[] buf = new char[10];
            int len;
            while ((len = isr.read(buf)) != -1) {
                String str = new String(buf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void t2() throws IOException{
        FileInputStream fis = new FileInputStream("hello.txt");
        FileOutputStream fos = new FileOutputStream("hello_gbk.txt");
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        // 使用字符集，取决于文件保存时使用的字符集
        char[] buf = new char[10];
        int len;
        while ((len = isr.read(buf)) != -1) {
           osw.write(buf,0,len);
        }

        isr.close();
        osw.close();

    }
}
