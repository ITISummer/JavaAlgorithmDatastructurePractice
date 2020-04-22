package datastructure.comparetest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Java中比较器测试
 */
public class CompareTest {
    @Test
    public void test1() {
        String[] arr = new String[]{"AA","CC","BB","KK","DD","JJ"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("xiaomi",34);
        goods[2] = new Goods("pingguo",55);
        goods[1] = new Goods("huawei",43);
        goods[3] = new Goods("lianxiang",11);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    @Test
    public void test3() {
        String[] arr = new String[]{"AA","CC","BB","KK","DD","JJ"};
        Arrays.sort(arr, new Comparator() {
            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1,Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致！");
            }
        });
        System.out.println(Arrays.toString(arr));
    } //end test3()

    @Test
    public void test4() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("xiaomi",34);
        goods[2] = new Goods("pingguo",55);
        goods[1] = new Goods("huawei",43);
        goods[3] = new Goods("lianxiang",11);

        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName().equals(o2.getName())) {
                    return -Double.compare(o1.getPrice(),o2.getPrice());
                } else {
                    return o1.getName().compareTo(o2.getName());
                } //end if...else
//                throw new RuntimeException("输入的数据类型不一致！");
            } //end compare()
        });
        System.out.println(Arrays.toString(goods));
    }
}
