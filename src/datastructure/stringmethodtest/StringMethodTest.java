package datastructure.stringmethodtest;

import org.junit.jupiter.api.Test;

/**
 * 此类用于测试String类的方法
 */
public class StringMethodTest {
    @Test
    public void test1() {
        String str1 = " HelloWorld ";
        System.out.println(str1.length());
        System.out.println(str1.charAt(5));
        System.out.println(str1.isEmpty());
        System.out.println(str1.toLowerCase());
        System.out.println(str1.toUpperCase());
        System.out.println(str1.trim());
        String str2 = "lv";
        System.out.println(str1.concat(str2));//字符串拼接
        System.out.println(str1.compareTo(str2));//字符串比较，可以用于字符串排序
        System.out.println(str1.contains(str2));//判断str1中是否包含str2，字符串匹配问题

    } //end test1()

    @Test
    public void test2() {
        /**
         * 常量与常量拼接的结果在常量池中，且常量池不会存在相同内容的常量
         * 只要其中一个是变量，结果就在堆中
         * 如果拼接的结果调用intern()方法，返回值就在常量池中。
         */
        String s1 = "helloworld";
        String s2 = "world"; //是变量
        String s3 = "hello"+s2;
        System.out.println(s1 == s3);

        final String s4 = "world"; //final修饰，是常量
        String s5 = "hello"+s4; //会去常量池查找是否存在相同的字符串
        System.out.println(s1 == s5);
    } //end test2()
}
