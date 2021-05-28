package datastructure.hashmaptest;


import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * |---------Map:双列数据，存储key-value键值对
 * |-----HashMap:作为Map的主要实现类，线程不安全，效率高，可存储值为null的key和value
 * |----------LinkedMap：保证在遍所map元素时，可纵按照添加的顺序实现遍历。
 * 原因：在原有的 HashMap底结构基础上，添加了一对指针，指向前一个和后了个元素
 * 对于频繁的遍历操作，此类执行高于HashMap
 * |------TreeMap: 保证添加的key:value进行排序添加，按照key来排序，此时考虑key的自然排序或者定制排序
 * 底层使用红黑树
 * |------HashTable:作为Map古老的实现类，线程安全的，效率低，不能存储值为null的key和value
 * |-----Properties:常用来处理配置文件。key和value都是 String类型
 * <p>
 * HashMap的底层：数组+链表（jdk7及之前）
 * 数组+链表+红黑树（jdk8）
 * <p>
 * <p>
 * 二、Map结构的理解Map中的ey：无序的、不可重复的，使用Set存储所有的key
 * Map中的 value：无序的、可重复的，使用 Collection.存储所有的 value
 * 一个键值对：key-vaue构成了一个 Entry对象
 * Map中的 entry：无序的、不可重复的，使用Se存储所有的 entry
 * <p>
 * 三、 HashMap的底层实现原理？以jdk7为例说明：
 * HashMap map new HashMap()
 * 在实例化以后，底层创建了长度是16的一维数组 Entry[] table
 * map.put（key,vaLue1）
 * -------情况1
 * 首先，调用key1所在类的 hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
 * 如果此位置上的数据为空，此时的key1- value1添加成功
 * <p>
 * -------情况2
 * 如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在），
 * 比数key1和已经存在的一个或多个数据的哈希值：
 * 如果key1的哈希值与已经存在的数据的哈希值都不相同，此的key1- value1添加成功
 * <p>
 * -------情况3
 * 如果key1的哈希值和已经存在的某一个数据（key2- value2）的哈希值相同，
 * 继续比较：调用key1所在类 equals(key2)如果 equals()返回faLse：此的key1-value1添加成功。
 * 如果 equaLs()返回true：使用value1替换vaue2。
 * <p>
 * 补充：关于情况2和情况3：此的key1- value1和原来的数据以链表的方式存储。
 * 在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来
 * jdk8相较于jk7在底层实现方面的不同:
 * 1. new HashMap()：底层没有创建一个长度为6的数组
 * 2.jk8底层的数组是：Node[]，而非 Entry[]
 * 3.首次调用put()方法时，底层创建长度为16的数组
 * 4.jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树
 * 当数组的某一个索引位置上的元素以链表形式存在的数据个数>8 且当前数组的长度>64时，
 * 此时此索引位置上的所有数据改为使用红黑树存储，便于数据的查找，因为红黑树中序遍历有序的树
 */
public class MapTest {
    @Test
    public void test1() {
        Map map = new HashMap();
//        map.put(null,123);
        map.put(null, null);//不会抛出异常，健壮性弱


//        map = new Hashtable();
//        map.put(null,123);//会抛出异常，健壮性强
    }
}
