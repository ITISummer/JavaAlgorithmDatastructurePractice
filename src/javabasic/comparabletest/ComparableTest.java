package javabasic.comparabletest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [java 比较器](https://www.bilibili.com/video/BV1Kb411W75N?p=490&spm_id_from=pageDriver)
 */
public class ComparableTest {
    /**
     * 1. String 重写了 Comparable 接口的 compareTo() 方法，所以可比较
     * 2. 重写 compareTo(obj) 规则：
     * 如果当前对象 this 大于形参对象 obj，则返回正整数
     * 如果当前对象 this 小于形参对象 obj，则返回负整数
     * 如果当前对象 this 等于形参对象 obj，则返回零
     */
    @Test
    public void test1() {
        String[] arr = new String[]{"aa", "cc", "ee", "bb", "dd"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 自然排序，得实现 Comparable 接口
     */
    @Test
    public void test2() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("a", 10.1);
        goods[1] = new Goods("c", 8.2);
        goods[2] = new Goods("b", 12.5);
        goods[3] = new Goods("d", 1.3);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /**
     * 定制排序，实现 Comparator 接口
     * 重写 compare()
     * 按字符串从大到小顺序排列
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"aa", "cc", "ee", "bb", "dd"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return -s1.compareTo(s2);
            }
        });
        System.out.println(Arrays.toString(arr));
        // 自定义类定制排序
        System.out.println("**********************************");
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("a", 10.1);
        goods[1] = new Goods("c", 8.2);
        goods[2] = new Goods("b", 12.5);
        goods[3] = new Goods("d", 1.3);
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods gs1, Goods gs2) {
                if (gs1.getName().equals(gs2.getName())) {
                    // 价格从高到低
                    return -Double.compare(gs1.getPrice(),gs2.getPrice());
                } else {
                    // 名字从低到高
                    return gs1.getName().compareTo(gs2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(goods));
    }

}
