package javabasic.javanewtest;

import org.junit.Test;

/**
 * Lambda 表达式使用
 */
public class LambdaTest {
    @Test
    public void t1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love Shenzhen");
            }
        };
        r1.run();
        System.out.println("*****************************");
        Runnable r2 = () -> System.out.println("I love xiao");
        r2.run();
    }

}
