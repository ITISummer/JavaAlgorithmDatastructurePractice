package javabasic.stringtest;


import org.junit.Test;
/*
[Junit测试出现异常：Exception in thread "main" java.lang.NoSuchMethodError: org.junit.platform.commons.util.]
(https://www.cnblogs.com/javaxiaodoufu/p/7520210.html)
[String 讲解](https://www.bilibili.com/video/BV1Kb411W75N?p=452&spm_id_from=pageDriver)
 */
/**
 * String 的使用
 */
public class StringTest {
    /**
     * 不可被继承
     * 实现了 Serializable 接口，表示可序列化
     * 实现了 Comparable 接口表示可比较大小
     * 内部定义了 final char[] value 用于存储字符串
     * 代表不可变的字符序列。
     */
    @Test
    public void test1() {
        // 方法区（含有字符串常量池，存储声明的相同内容的字符串）
        String s1 = "abc";

        String s2 = "abc";
        System.out.println(s1 == s2); // true

        String s3 = s2.replace('a','b');
        System.out.println(s3); // bbc
        System.out.println(s1); // abc
    }

    @Test
    public void test2(){
        Person p1 = new Person("Tom");
        Person p2 = new Person("Tom");
        System.out.println(p1.name.equals(p2.name)); //true
        System.out.println(p1.name == p2.name); //true
    }

    /*
    结论：
    常量与常量的拼接结果在常量池中。且常量池中不会存在相同内容的常量
    只要其中有一个是变量，结果就在堆中
    如果拼接的结果调用 intern() 方法，返回值就在常量池中
     */
    @Test
    public void test3(){
        String s1 = "java";
        String s2 = "hadoop";

        String s3 = "javahadoop";
        String s4 = "java" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "java" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        String s8 = s5.intern(); // 从常量池返回结果
        System.out.println(s3 == s8); // true
    }
}

/**
 * Person
 */
class Person{
    String name;
    public Person(String name) {
        this.name = name;
    }
}
