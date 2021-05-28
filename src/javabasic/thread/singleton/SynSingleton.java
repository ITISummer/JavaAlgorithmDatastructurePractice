package javabasic.thread.singleton;

/**
 * 线程安全的懒汉式单例模式
 */
public class SynSingleton {
    // 2. 创建静态变量
    private static SynSingleton instance = null;
    // 1. 私有化构造器
    private SynSingleton(){
        System.out.println("线程安全的懒汉式单例模式");
    }
    public static SynSingleton getInstance() {
        // 方式一：效率稍差
//        synchronized (SynSingleton.class) {
//            if (instance == null) {
//                instance = new SynSingleton();
//            }
//            return instance;
//        }
        // 方式二：效率更高 - 建议懒汉式单例模式写法
        if (instance == null) {
           synchronized (SynSingleton.class) {
               if (instance == null) {
                   instance = new SynSingleton();
               }
           }
        }
        return instance;
    }
}
