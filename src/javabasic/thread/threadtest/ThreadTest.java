package javabasic.thread.threadtest;
// [Java中为什么没有多继承](https://blog.csdn.net/louisia/article/details/52091746)

import java.util.concurrent.*;

/**
 * 1-1. 线程创建方式一 - 继承 Thread 类
 */
class MyThread extends Thread {
    // 1-2. 重写 run 方法
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(getName() + ":" + i);
            }
        }
    }
}

/**
 * 2-1. 线程创建方式二 - 实现 Runnable 类
 */
class MyRunnable implements Runnable {
    // 2-2. 实现抽象方法 run()
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

/**
 * 3-1. 线程创建方式三 - 实现 Callable 类
 * 如何理解实现 Callable 接口的方式创建多线程比实现 Runnable 接口创建多线程方式强大？
 * 1. call() 可以有返回值
 * 2. call() 可以抛出异常，被外面的操作捕获，获取异常信息
 * 3. Callable 支持泛型
 */
class MyCallable implements Callable{

    // 3-2 实现 call() 方法
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        // 这里设计 int 的自动封装为 Integer, 由于 Integer 为 Object 的子类（多态性），所以此处未报错。
        return sum;
    }
}

/**
 * 4-1. 线程创建方式四 - 线程池
 * 好处：
 * 1. 提高响应速度（减少了创建新线程的时间）
 * 2. 降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3. 便于线程管理
 */
class MyThreadPoll {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 创建一个线程池（固定容量）
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 2. 执行
//        service.execute(new MyRunnable()); // 适合 Runnable
        Future<Integer> future = service.submit(new MyCallable()); // 适合 Callable
        System.out.println(future.get());

        // 3. 关闭线程池
        service.shutdown();
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        // 1-3. 创建一个线程对象
//        MyThread mt1 = new MyThread();
        // 1-4. 启动线程
//        mt1.start();
        //==================2================
        // 2-3. 创建一个线程对象
//        MyRunnable mr1 = new MyRunnable();
        // 2-4. 讲此对象作为参数传递到 Thread 类中
//        Thread t1 = new Thread(mr1);
        // 2-5. 通过 Thread 类的对象调用 start()
//        t1.start();
        //=================3=================
        // 3-3 创建 callable 对象实例
        MyCallable mc1 = new MyCallable();
        // 3-4 实例化 FutureTask
        FutureTask futureTask = new FutureTask(mc1);
        // 3-5 创建线程对象
        Thread t1 = new Thread(futureTask);
        // 3-6 启动线程
        t1.start();
        try {
            // 获取 call() 的返回值
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
