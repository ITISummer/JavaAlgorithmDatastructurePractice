package javabasic.collectiontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List 类使用
 * ArrayList
 * - jdk7 中 底层创建长度为 10 的 Object[]，如果长度不够则默认扩容为原来 1.5 倍
 * - 建议开发中使用带参构造器 List list = new ArrayList(int capacity)
 * - jdk8 是第一次 add 时才是初始化初始长度为 10
 * - jdk7 类似于单例的饿汉式，jdk8 则类似于懒汉式
 * LinkedList： 双向链表
 * - LinkedList list = new LinkedList(); 内部声明了 Node 类型的 first 和 last 属性，默认值为 null
 */
public class ListTest {
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(233);
        list.add('c');
        list.add("bb");
        list.add(1.2);
        System.out.println(list);

//        list.addAll()
//        list.get()
//        list.indexOf()
//        list.lastIndexOf()
//        list.remove()
//        list.set()
//        list.subList()
        System.out.println("************************");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("************************");
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("************************");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    /**
     * List 小练习：区别 remove 参数
     */
    @Test
    public void test2() {
        List list = new ArrayList(3);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println("************************");
//        list.remove(2);
//        System.out.println(list);
        list.remove(new Integer(2));
        System.out.println(list);
    }
}
