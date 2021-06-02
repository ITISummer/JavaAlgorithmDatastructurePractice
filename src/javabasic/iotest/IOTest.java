package javabasic.iotest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * IO 流
 */
public class IOTest {
    /**
     * File 类的一个对象就代表一个文件或者文件夹
     */
    @Test
    public void t1() {
        // 相对于当前 module
        File f1 = new File("hello.txt");
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getParent()); // null
        System.out.println(f1.getName());
        System.out.println(f1.getPath());
        System.out.println(f1.length());
        System.out.println(f1.lastModified());
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        System.out.println(f1.canRead());
        System.out.println(f1.canWrite());
        System.out.println(f1.isHidden());
        System.out.println("******************************");
        // 获取文件或者文件目录
        File f2 = new File("src");
        String[] list = f2.list();
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("******************************");
        File[] files = f2.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }

    /**
     * 创建文件
     */
    @Test
    public void t2() {
       File file = new File("hi.txt");
       if (!file.exists()) {
           try {
               file.createNewFile();
               System.out.println("创建文件成功！");
           } catch (IOException e) {
               e.printStackTrace();
           }
       } else {
           file.delete();
           System.out.println("文件已存在！删除成功！");
       }
       // 文件目录的创建
       System.out.println("***************************");
       File file1 = new File("summer/test");
       if (!file1.exists()) {
//           if (file1.mkdir()){ // 失败
          if (file1.mkdirs()) {
               System.out.println("创建文件夹成功！");
           } else {
               System.out.println("创建文件夹失败！");
           }
       }
    }
}
