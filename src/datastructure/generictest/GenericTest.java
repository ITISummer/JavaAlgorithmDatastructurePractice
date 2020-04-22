package datastructure.generictest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 体会泛型
 * jdk1.5(5.0)新增的内容
 */
public class GenericTest {

    @Test
    public void test1() {
        List list = new ArrayList();
        //存放学生的成绩
        list.add(99);
        list.add(100);
        list.add(98);

        //因为是Object类型的，所以会容易混入其他类型的数据
        list.add("name");

        //当在进行输出数据的时候，如果强制转换成Integer类型的数据，则会出现ClassCastException异常
        //即类型转换错误，因为不能从字符串型转换成Integer类型的

    } //end test1()


    @Test
    public void test2() {
        //使用泛型，在创建集合的时候就给定该集合里面的数据类型
        List<Integer> list = new ArrayList<>();
        list.add(98);
        list.add(99);
        list.add(100);

//        list.add("name");指定Integer类型，放入其他类型，编译不通过

    }




}
