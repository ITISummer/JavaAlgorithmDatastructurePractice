package javabasic.genericstest;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * 泛型在继承方面的体现
 *
 * 通配符 ?
 *
 */
public class GenericsTest2 {
    /**
     * 泛型在继承方面的体现
     * 类 A 是 类 B的父类
     * G<A> 和 G<B> 不具备子父类关系，二者是并列关系
     * [泛型类补充](https://www.bilibili.com/video/BV1Kb411W75N?p=572&spm_id_from=pageDriver)
     * A<G> 则是 B<G> 的父类
     */
    @Test
    public void t1() {
        List<Object> l1 = null;
        List<String> l2 = null;
        // 此时 l1 和 l2 不具有子父类继承关系
//        l1 = l2;
    }

    /**
     * 通配符的使用
     * 类 A 是 类B 的父类
     * G<A> 与 G<A> 是并列关系，二者共同父类为 G<?>
     */
    @Test
    public void t2() {
       List<Object> l1 = null;
       List<String> l2 = null;

       List<?> l = null;
       l = l1;
       l = l2;
       print(l1);
       print(l2);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
