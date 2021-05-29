package javabasic.maptest;

/**
 * Map 接口使用
 * |---Map：双列数据，存储 key-value 键值对的数据
 *      |---HashMap: 作为 Map 的主要实现类；线程不安全的，效率高；可存储 null 值的 key 和 value
 *          |---LinkedHashMap : 保证遍历元素时，可以按照添加的顺序实现遍历。
 *              原因：在原有的 HashMap 底层结构基础上，添加了一对引用（指针），分别指向前一个和后一个添加的元素
 *              对于频繁的遍历操作，考虑使用 LinkedHashMap
 *      |---TreeMap: 保证按照添加的 key-value 对进行排序，实习排序遍历，此时考虑 key 的自然排序（实现Comparable）或者定制排序（实现Comparator）
 *                  底层使用 红黑树
 *      |---Hashtable 古老的实现类；线程安全的，效率低；不能存储 null 值的 key 和 value
 *          |---Properties: 常用于处理配置文件。key与value都是 String 类型的。
 *
 *
 * HashMap 底层：数组+链表（jdk7 之前）
 *              数组+链表+红黑树（jdk8）
 *
 * 二、Map 结构的理解
 * 以 HashMap 为例说明
 * Map 中的 key: 无序不可重复的，使用 Set 存储所有的 key -> 要求 key 所在的类要重写 hashCode() 和 equals()
 * Map 中的 value：无序可重复的，使用 Collection 存储所有的 value -> 要求 value 所在类重写 equals()
 * Map 中的 entry：无序、不可重复的，使用 Set 存储所有的 entry
 *
 * 三、HashMap 底层实现原理
 * jdk7：
 *
 */
public class MapTest {

}
