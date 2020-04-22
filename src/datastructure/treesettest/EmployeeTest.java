package datastructure.treesettest;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建5个Employee对象，放入TreeSet中，注意需要Employee实现Comparable接口
 */
public class EmployeeTest {

    @Test
    public void test1() {
        TreeSet set = new TreeSet();
        Employee emp1 = new Employee("liudehua", 65, new MyDate(1965, 11, 11));
        Employee emp2 = new Employee("guoxiang", 35, new MyDate(1935, 11, 12));
        Employee emp3 = new Employee("liuhai", 5, new MyDate(2065, 1, 1));
        Employee emp4 = new Employee("hailiu", 25, new MyDate(1345, 3, 31));
        Employee emp5 = new Employee("lihua", 10, new MyDate(2005, 8, 15));

        set.add(emp1);
        set.add(emp2);
        set.add(emp3);
        set.add(emp4);
        set.add(emp5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    } //end test1()

    /**
     * 按照生日顺序排序
     */
    @Test
    public void test2() {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    //方式一：
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthDay();
                    MyDate b2 = e2.getBirthDay();
//                    //比较年
//                    int minusYear = b1.getYear() - b2.getYear();
//                    if (minusYear != 0) {
//                        return minusYear;
//                    }
//                    //比较月
//                    int minusMonth = b1.getMonth() - b2.getMonth();
//                    if (minusMonth != 0) {
//                        return minusMonth;
//                    }
//                    //比较日
//                    return b1.getDay() - b2.getDay();

                    return b1.compareTo(b2);
                }
                throw new RuntimeException("传入数据类型不一致！");
            }
        });
        Employee emp1 = new Employee("liudehua", 65, new MyDate(1965, 11, 11));
        Employee emp2 = new Employee("guoxiang", 35, new MyDate(1935, 11, 12));
        Employee emp3 = new Employee("liuhai", 5, new MyDate(2065, 1, 1));
        Employee emp4 = new Employee("hailiu", 25, new MyDate(1345, 3, 31));
        Employee emp5 = new Employee("lihua", 10, new MyDate(2005, 8, 15));

        set.add(emp1);
        set.add(emp2);
        set.add(emp3);
        set.add(emp4);
        set.add(emp5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
