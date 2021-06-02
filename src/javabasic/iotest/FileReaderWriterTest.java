package javabasic.iotest;

import org.junit.Test;

import java.io.*;

/**
 * 流的分类：
 * 数据流向：输入流、输出流
 * 根据操作数据单位： 字节流、字符流
 * 流的角色：节点流，处理流
 */
public class FileReaderWriterTest {
    /**
     * 当涉及到物理层面的连接时，最后不要使用 throws 抛出异常
     * 使用 try{}catch() 手动捕获异常并在 finally{} 中手动关闭连接
     */
    @Test
    public void t1() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {

        } finally {
            // 关闭流 - 不手动关闭容易导致内存泄漏问题
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * read() 的重载方法
     */
    @Test
    public void t2() {
        // File 类的实例化
        File file = new File("hello.txt");
        FileReader fr = null;
        try {
            // FileReader 流的实例化
            fr = new FileReader(file);
            // 一次读入 5 个字符
            char[] buf = new char[5];
            // 读入操作
            int len;
            while ((len = fr.read(buf)) != -1) {
//                if (len < buf.length) {
//                    for (int i = 0;i<len;i++) {
//                        System.out.print(buf[i]);
//                    }
//                    return;
//                }
//                System.out.print(buf);

                //"*****************************"
                String str = new String(buf, 0, len);
                System.out.print(str);
            }
            // 流的关闭
        } catch (IOException e) {

        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从内存中写出数据到硬盘里
     * 写出时文件不存在则会创建
     */
    @Test
    public void t3() {
        File file = new File("hello.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,true);
            fw.write("\nI have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

