package javabasic.iotest;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流
 */
public class BufferedTest {
    @Test
    public void t1() {
        // 创建文件
        File srcFile = new File("bg.jpg");
        File destFile = new File("bg_copy.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream br = null;
        BufferedOutputStream bw = null;
        try {
            // 创建流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 创建缓冲流
            br = new BufferedInputStream(fis);
            bw = new BufferedOutputStream(fos);
            // 开始复制
            byte[] buf = new byte[10];
            int len;
            while ((len = br.read(buf)) != -1) {
                bw.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流，先关闭外层流再关闭内层流
            try {
                if (bw != null)
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null)
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 关闭外层流时，内存流也会被关闭，所以只需要写关闭外层流的操作即可
//            try {
//                if (fos != null)
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (fis != null)
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

    }
    @Test
    public void t2() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello_copy.txt")));
            // 开始复制
//            char[] buf = new char[10];
//            int len;
//            while ((len = br.read(buf)) != -1) {
//                bw.write(buf,0,len);
//            }
            // 开始复制
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line); // data 中不包含换行符
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流，先关闭外层流再关闭内层流
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
