package javabasic.reflectiontest;

/**
 * 接口
 */
interface ClothFactory {
    void produceCloth();
}

/**
 * 代理类
 */
class ClothFactoryProxy implements ClothFactory {
    private ClothFactory clothFactory;

    public ClothFactoryProxy(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        clothFactory.produceCloth();
        System.out.println("代理工厂做一些后续收尾工作");
    }
}

/**
 * 被代理类
 */
class Nike implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike 生产 Nike 鞋子");
    }
}

/**
 * 静态代理：代理类和被代理类在编译期间就确定下来了
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建被代理类对象
        ClothFactory nike = new Nike();
        // 创建代理类对象
        ClothFactory clothFactoryProxy = new ClothFactoryProxy(nike);

        clothFactoryProxy.produceCloth();

    }
}
