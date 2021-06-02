package javabasic.reflectiontest;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest {
    @Test
    public void t1() throws InstantiationException, IllegalAccessException {
        Class<Person> c1 = Person.class;
        Person p1 = c1.newInstance();
        System.out.println(p1);
        System.out.println("*****************************");
        // 获取当前运行时类及其父类中声明为 public 访问权限的属性
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("*****************************");
        // 获取当前运行时类的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }
    @Test
    public void t2() throws InstantiationException, IllegalAccessException {
        Class<Person> c1 = Person.class;
        System.out.println("*****************************");
        // 获取当前运行时类及其父类中声明为 public 访问权限的属性
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            // 获取权限修饰符
            System.out.print(Modifier.toString(field.getModifiers())+"\t");
            // 数据类型
            Class type = field.getType();
            System.out.print(type.getName()+"\t");
            // 变量名
            System.out.print(field.getName());
        }

    }
}
