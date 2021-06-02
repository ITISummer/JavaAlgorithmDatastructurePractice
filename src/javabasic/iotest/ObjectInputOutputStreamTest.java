package javabasic.iotest;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * ObjectInputStream 和 ObjectOutputStream
 * 作用：用于存储和读取基本数据类型数据和对象的处理流。
 */
public class ObjectInputOutputStreamTest {
    @Test
    public void t1() throws IOException {
        // 序列化过程
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.dat"));
        oos.writeObject(new String("我的世界"));
        oos.flush();// 刷新操作
        oos.close();
    }
    @Test
    public void t2() throws IOException, ClassNotFoundException {
        // 反序列化过程
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.dat"));
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
    }
}
