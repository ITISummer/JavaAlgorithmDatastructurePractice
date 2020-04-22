package datastructure.hashmaptest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件信息的类
 */
public class PropertiesTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            //获取文件输入流
            fis = new FileInputStream("D:\\IntellijIdeaWorkplace\\javaDataStructureAndAlgorithm\\src\\hashmaptest\\jdbc.properties");
            //加载流对应的文件
            pros.load(fis);
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name:"+name+",password:"+password);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } //end try...catch
            } //end if
        } //end try...catch...finally
    } //end main()
}
