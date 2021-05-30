package javabasic.genericstest;

import org.junit.Test;

/**
 * 泛型类的定义
 */
class GenericsClass<E> {
    private E value;

    /**
     * 泛型方法
     * 在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
     * 泛型方法所属的类是不是泛型类都没有关系
     * @param value
     * @param <E>
     * @return
     */
    public <E> E genericsMethod(E value) {
        return value;
    }
    /**
     * 泛型方法
     * @param value
     * @param <T>
     * @return
     */
    private <T> T genericsMethod_2(T value) {
        return value;
    }

    /**
     * 重载泛型方法
     * 泛型方法可以声明为静态的，因为其参数类型是在调用时确定的，并非所在类实例化对象时确定的。
     */
    static <T,V> T  genericsMethod(T value1,V value2) {
        return value1;
    }

    /*
     * 如下三个方法不是范型方法
     */
    public GenericsClass(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericsClass{" +
                "value=" + value +
                '}';
    }
}
/**
 * 泛型使用
 */
public class GenericsTest {
    @Test
    public void t1() {
        GenericsClass<String> gc = new GenericsClass<>("lvlv");
        System.out.println(gc);
    }
}