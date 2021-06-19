package javabasic.maptest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Map 接口使用
 * |---Map：双列数据，存储 key-value 键值对的数据
 * |---HashMap: 作为 Map 的主要实现类；线程不安全的，效率高；可存储 null 值的 key 和 value
 * |---LinkedHashMap : 保证遍历元素时，可以按照添加的顺序实现遍历。
 * 原因：在原有的 HashMap 底层结构基础上，添加了一对引用（指针），分别指向前一个和后一个添加的元素
 * 对于频繁的遍历操作，考虑使用 LinkedHashMap
 * |---TreeMap: 保证按照添加的 key-value 对进行排序，实习排序遍历，此时考虑 key 的自然排序（实现Comparable）或者定制排序（实现Comparator）
 * 底层使用 红黑树
 * |---Hashtable 古老的实现类；线程安全的，效率低；不能存储 null 值的 key 和 value
 * |---Properties: 常用于处理配置文件。key与value都是 String 类型的。
 * <p>
 * <p>
 * HashMap 底层：数组+链表（jdk7 之前）
 * 数组+链表+红黑树（jdk8）
 * <p>
 * 二、Map 结构的理解
 * 以 HashMap 为例说明
 * Map 中的 key: 无序不可重复的，使用 Set 存储所有的 key -> 要求 key 所在的类要重写 hashCode() 和 equals()
 * Map 中的 value：无序可重复的，使用 Collection 存储所有的 value -> 要求 value 所在类重写 equals()
 * Map 中的 entry：无序、不可重复的，使用 Set 存储所有的 entry
 * <p>
 * 三、HashMap 底层实现原理
 * jdk7：
 */
public class MapTest {
    /**
     * 1、如果遍历 hashMap() 时 entrySet() 方法是将 key 和 value 全部取出来,所以性能开销是可以预计的,
     * 而 keySet() 方法进行遍历的时候是根据取出的 key 值去查询对应的 value 值,
     * 所以如果 key 值是比较简单的结构(如 1,2,3...)的话性能消耗上是比 entrySet() 方法低,
     * 但随着 key 值得复杂度提高 entrySet() 的优势就会显露出来。
     * <p>
     * 2、综合比较在只遍历 key 的时候使用 keySet(), 在只遍历 value 的是使用 values() 方法,
     * 在遍历 key-value 的时候使用 entrySet() 是比较合理的选择。
     * <p>
     * 3、如果遍历 TreeMap 的时候, 不同于 HashMap.
     * 在遍历 ThreeMap 的 key-value 时候务必使用 entrySet() 它要远远高于其他两个的性能,
     * 同样只遍历 key 的时候使用 keySet(), 在只遍历 value 的是使用 values() 方法对于 TreeMap 也同样适用。
     */
    @Test
    public void test1() {
        Map map = new HashMap();
        map.put("a", 123);
        map.put("b", 124);
        map.put("c", 125);
        map.put("c", 126); // 修改 125,所以最终 map 中包含 126
        System.out.println(map);
        System.out.println("***********通过Map.keySet使用iterator遍历key和value*********");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
        }
        System.out.println("***********通过Map.keySet遍历key和value[普遍使用]*********");
        for (Object o : map.keySet()) {
            System.out.println(map.get(o));
        }
        System.out.println("********通过Map.values()遍历所有的value，但不能遍历key************");
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
        System.out.println("**********推荐，尤其是容量大时**********");
        Iterator iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    /**
     * TreeMap 使用
     * 向 TreeMap 中添加 value，要求必须是同一类元素，因为底层红黑树要按照 key 进行排序（自然排序，定制排序）
     */
    @Test
    public void test2() {
        Person p1 = new Person("tom");
        Person p2 = new Person("tam");
        Person p3 = new Person("tim");
        Map map = new TreeMap();
        map.put(p1, "p1");
        map.put(p2, "p2");
        map.put(p3, "p3");
        for (Object o : map.keySet()) {
            System.out.println(o + "-->" + map.get(o));
        }
        System.out.println("************************");
        Map map1 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o instanceof Person && t1 instanceof Person) {
                    return ((Person) o).getName().compareTo(((Person) t1).getName());
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        map1.put(p1, "p1");
        map1.put(p2, "p2");
        map1.put(p3, "p3");
        Set entrySet = map1.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    /**
     * Properties 使用
     */
    @Test
    public void test3() {
        Properties p = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/javabasic/maptest/jdbc.properties");
            p.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(p.get("name"));
        System.out.println(p.get("password"));
    }
}

class Person implements Comparable {
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
