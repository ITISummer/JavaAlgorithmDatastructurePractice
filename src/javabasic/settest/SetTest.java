package javabasic.settest;

import org.junit.Test;

import java.util.*;

/**
 * Set 的使用
 * Collection：接口，单例集合，用来存储一个个对象
 *      |---Set 接口，存储无序的，不可重复的数据 ***
 *      |---HashSet : 主要实现类，线程不安全，可以存储 null 值
 *          |---LinkedHashSet: 作为 HashSet 子类；遍历其内部数据时，可以按照添加的顺序遍历
 *      |---TreeSet： 可以按照添加对象的指定属性进行排序
 */
public class SetTest {
    /**
     * 一： Set： 存储无序的，不可重复的数据
     * 以 HashSet 为例
     * 其中没有定义其他方法，使用的都是继承自 Collection 中的方法
     *      无序性： 不等于随机性（不是按添加顺序输出），内部有按默认顺序输出（根据对象的哈希值，在数组中进行存储）
     *      不可重复性： 保证添加的元素按照 hashCode() 和 equals() 判断时，不能都返回 true，即相同元素只能添加一个
     * 二： 添加元素的过程
     *      添加元素 a，首先调用元素 a 所在类的 hashCode() 方法，计算元素 a 的哈希值，
     *      此哈希值接着通过某种算法在 HashSet 底层数组中的存放位置（即为：索引位置）,判断数组此位置是否已有元素
     *      如果此位置上没有元素，则元素 a，添加成功 -》情况 1
     *      如果此位置上有其他元素 b，（或以链表形式存在多个元素），则比较 a 与元素 b 的 hash 值
     *          如果 hash 值不同，则元素 a 添加成功 -》情况 2
     *          如果 hash 值相同，进而需要调用 a 所在类的 equals() 方法：
     *              equals() 返回 true，元素 a 添加失败
     *              equals() 返回 false，则元素 a 添加成功 -》情况 3
     *
     * 对于添加成功的情况1 和情况2而言，元素 a 与已经存在的指定索引位置上数据以链表方式存储。
     *      jdk7： 元素 a 放在数组中，指向原有元素
     *      jdk8： 原来元素在数组中，指向元素 a
     *      总结：七上八下
     *
     * HashSet 底层为数组+链表结构
     *
     * 向 set 中添加数据，数据所在类一定要重写 hashCode() 和 equals() 方法
     * 要求重写的 hashCode() 和 equals() 尽可能保持一致性，相等的对象必须具有相同的 hashcode
     * 重写技巧： （计算 hashcode 和 equals 的类属性尽量一样）
     */
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add("1A");
        set.add(11);
        set.add('c');
        set.add(1.2);
        set.add(new Person("lvlv"));
        set.add(new Person("lvlv"));
        System.out.println(set);
        System.out.println("************************");

    }

    /**
     * LinkedHashSet 使用
     * 作为 HashSet 子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据。
     * 优点：对于频繁的遍历操作，LinkedHashSet 效率高于 HashSet
     */
    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add("1A");
        set.add(11);
        set.add('c');
        set.add(1.2);
        set.add(new Person("lvlv"));
        set.add(new Person("lvlv"));
        System.out.println(set);
        System.out.println("************************");

    }

    /**
     * TreeSet
     * 1. 向 TreeSet 添加数据，要求是想同类的对象且类需要能够比较（实现 Comparable 接口）
     * 2. 默认从低到高排序
     * 3. 判断相等是根据自然排序（实现Comparable接口）和定制排序（实现Comparator接口）返回结果，不是根据 equals()（和 HashSet 不一样，HashSet 根据 hashCode() 和 equals()）
     * 4. 底层为（红黑树）- 排序二叉树
     *
     */
    @Test
    public void test3() {
        Set set = new TreeSet();
        set.add(12);
        set.add(11);
        set.add(-1);
        set.add(1);
        System.out.println(set);
        System.out.println("************************");
        Set set1 = new TreeSet();
        set1.add(new Person("ac"));
        set1.add(new Person("ab"));
        set1.add(new Person("cd"));
        set1.add(new Person("ca"));
        set1.add(new Person("mm"));
        Iterator iterator = set1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("************************");
        /*
         * 匿名子实现类创建对象方式
         */
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o instanceof Person && t1 instanceof Person) {
                    return ((Person) o).getName().compareTo(((Person) t1).getName());
                }
                throw new RuntimeException("类型不匹配");
            }
        };
        Set set2 = new TreeSet(comparator);
        set2.add(new Person("ac"));
        set2.add(new Person("ab"));
        set2.add(new Person("cd"));
        set2.add(new Person("ca"));
        set2.add(new Person("mm"));
        for (Object o : set2) {
            System.out.println(o);
        }


    }
}

class Person implements Comparable{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals 被调用......");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Object o) {
        if (o != null && o instanceof Person) {
            return this.getName().compareTo(((Person) o).getName());
        }
        throw new RuntimeException("类型不匹配");
    }
}
