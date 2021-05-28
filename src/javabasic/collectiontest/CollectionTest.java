package javabasic.collectiontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * java 集合测试
 */
public class CollectionTest {
    @Test
    public void test1() {
       Collection coll = new ArrayList();
       // add(e)
        coll.add("aa");
        coll.add(2);
        coll.add(1.2f);
        coll.add(new String[]{"a","b"});
        coll.add('r');
        // size()
        System.out.println(coll.size());//5
        // addAll()
        Collection coll1 = new ArrayList();
        coll1.add(234);
        coll1.add("bb");
        coll.addAll(coll1);
        System.out.println(coll.size());//7
        System.out.println(coll.toString());

        System.out.println(coll.isEmpty()); // false

        // clear() - 清空集合，并不是设置为 null
        coll.clear();

        System.out.println(coll.isEmpty()); // true
    }

    /**
     * collection 中常用方法测试
     */
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add("aa");
        coll.add(new String("lv"));
        coll.add(1.2f);
        coll.add('r');

        System.out.println(coll.contains("aa"));//true
        System.out.println(coll.contains(new String("lv"))); //true - 判断内容：调用 equals()

        System.out.println("**********************************");
        // iterator - 返回 Iterator 接口的实例，用于遍历集合元素
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("**********************************");
        // 增加 for 循環 - foreach - 底層也是使用 iterator - jdk5 新增
        for (Object o : coll) {
            System.out.println(o);
        }
    }
}
