package javabasic.reflectiontest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getBelief();

    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like to eat " + food);
    }
}

/**
 * 代理类 - 通过反射动态生成（体现反射的动态性）
 * Q1：如何根据加载到内存中的被代理类，动态的去创建代理类及其对象。
 * Q2：当通过代理类对象调用方法时，如何动态的去调用被代理类中的同名方法。
 */
class ProxyFactory {
    public static Object getProxyInstance(Object obj) {//obj: 被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        //绑定为被代理类对象
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    // AOP
    HumanUtil humanUtil = new HumanUtil();
    // 被代理类对象，由于是动态绑定，所以声明为 Object
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    /**
     * 当我们通过代理类的对象调用方法 a 时，就会自动的调用如下的 invoke()
     * 将被代理类要执行的方法 a 的功能声明在 invoke() 中
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        humanUtil.method1();

        // method() 为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        // obj: 被代理类的对象
        Object object = method.invoke(obj, args);
        // 返回值为调用被代理类对象要调用的方法的返回值

        humanUtil.method2();
        return object;
    }
}

/**
 * AOP应用-动态调用
 */
class HumanUtil {
    public void method1() {
        System.out.println("==============通用方法1===============");
    }

    public void method2() {
        System.out.println("==============通用方法2===============");
    }
}

/**
 * 动态代理-利用反射
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // 代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("Hamburger");
    }
}
