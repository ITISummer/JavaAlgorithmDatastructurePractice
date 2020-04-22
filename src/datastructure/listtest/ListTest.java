package datastructure.listtest;

/**
 * 本类用于对List接口进行测试
 * |------Collection接口：单列集合，用来存储一个个对象
 *      |---------List接口：存储有序的可重复的数据--》动态数组，替换原有数组
 *          |---------ArrayList:作为List接口的主要实现类：线程不安全的，效率高，底层使用Object[] elementData数组
 *          |---------LinkedList:对于频繁的插入，删除操作使用此类比ArrayList效率高，底层使用双向链表存储
 *          |---------vector:作为List的古老实现类：线程安全的，效率低：底层使用Object[] elementData数组
 * 开发注意事项：
 *          1. 在开发时使用带参构造器，构造出适合自己程序使用的数组的大小，效率相对会提高，如：List list = new ArrayList(50);
 *
 */
public class ListTest {
    public static void main(String[] args) {

    }


}
