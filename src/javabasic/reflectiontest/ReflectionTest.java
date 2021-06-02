package javabasic.reflectiontest;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Java 反射使用
 */
public class ReflectionTest {
    @Test
    public void t1() throws
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchMethodException, NoSuchFieldException {
        System.out.println("********通过反射创建对象*********");
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, Integer.class);
        Person p1 = (Person) constructor.newInstance("lvlv", 18);
        System.out.println(p1);
        System.out.println("********调用指定属性和方法*********");
        //2. 通过反射，调用对象指定的属性和方法
        Field age1 = clazz.getDeclaredField("age");
        // 修改对象属性值
        age1.set(p1, 10);
        System.out.println(p1.toString());
        // 调用方法
        Method say = clazz.getDeclaredMethod("say", String.class);
        say.invoke(p1, new String("I love programming"));

        System.out.println("********私有结构调用*********");
        // 通过反射是可以调用类的私有结构。比如：私有的构造器，方法，属性。
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p2 = (Person) cons1.newInstance("summer");
        System.out.println(p2);
        System.out.println("********设置私有属性*********");
        Field name = clazz.getDeclaredField("name");
        Field age2 = clazz.getDeclaredField("age");
        name.setAccessible(true);
        name.set(p2, "summerlv");
        age2.set(p2, 18);
        System.out.println(p2);
        // 调用私有方法
        Method listen = clazz.getDeclaredMethod("listen");
        listen.setAccessible(true);
        listen.invoke(p1);
    }

    /**
     * 获取 Class 的实例的方式
     */
    @Test
    public void t2() throws ClassNotFoundException {
        // 方式一：
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        System.out.println("********************");
        // 方式二： 通过运行时类的对象
        Person p1 = new Person("lvlv", 12);
        Class<Person> clazz2 = (Class<Person>) p1.getClass();
        System.out.println(clazz2);
        System.out.println("********************");
        // 使用较多的方式-方式三：调用 Class 的静态方法：forName(String classPath)
        Class<Person> clazz3 = (Class<Person>) Class.forName("javabasic.reflectiontest.Person");
        System.out.println(clazz3);
        System.out.println("********************");
        // 方式四：使用类加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<Person> clazz4 = (Class<Person>) classLoader.loadClass("javabasic.reflectiontest.Person");
        System.out.println(clazz4);
        System.out.println("********************");
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
        System.out.println(clazz3 == clazz4);
    }

    /**
     * Class 实例可以为一下结构
     */
    @Test
    public void t3() {
        Class c1 = Object.class; // 类
        Class c2 = Comparable.class; // 接口
        Class c3 = String[].class; // 引用类型一维数组
        Class c4 = int[][].class; // 基本类型二维数组
        Class c5 = ElementType.class; // 枚举
        Class c6 = Override.class; // 注解
        Class c7 = int.class; // 基本类型
        Class c8 = void.class; // 空
        Class c9 = Class.class; // 类类型

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个 Class
        System.out.println(c10 == c11);
    }
}
