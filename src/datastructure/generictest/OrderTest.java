package datastructure.generictest;


import org.junit.Test;

/**
 * 测试自定义泛型类 Order
 */
public class OrderTest{
    @Test
    public void test1() {

        /**
         * 如果定义了泛型类，实例化时没有指明泛型类的类型，则认为此泛型类为Object类型
         * 要求：如果大家定义了类是带泛型的，建议在示例化时指明泛型类的类型
         */
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        /**
         * 指明泛型类型
         */

        Order<String> order1 = new Order<>("lvchangxu",123,"hhhhh");
        System.out.println(order1);


    }
}
