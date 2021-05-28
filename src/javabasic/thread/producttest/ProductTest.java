package javabasic.thread.producttest;

class Clerk {
   private int productCount = 0;
   /**
    * 生产产品
    * 此时同步监视器为 Clerk 的实例对象，在 main() 中只有一个
    */
   public synchronized void produceProduct() {
      if (productCount < 20) {
         productCount++;
         System.out.println(Thread.currentThread().getName()+": 开始生产第"+productCount+"个产品");
         // 生产者生产了一个产品即可唤醒消费者去消费
         notify();
      } else {
         try {
            wait();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   /**
    * 消费产品
    * 此时同步监视器为 Clerk 的实例对象，在 main() 中只有一个
    */
   public synchronized void consumeProduct() {
      if (productCount > 0) {
         System.out.println(Thread.currentThread().getName()+": 开始消费第"+productCount+"个产品");
         productCount--;
         // 消费者消费了一个产品即可唤醒生产者去生产
         notify();
      }else {
         try {
            wait();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
/**
 * 生产者
 */
class Producer extends Thread{
   private Clerk clerk;
   public Producer(Clerk clerk) {
      this.clerk = clerk;
   }

   @Override
   public void run() {
      System.out.println(getName()+": 开始生产...");
      while (true) {
         try {
            Thread.sleep(10);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         clerk.produceProduct();
      }
   }
}

/**
 * 消费者
 */
class Consumer extends Thread{
   private Clerk clerk;
   public Consumer(Clerk clerk) {
      this.clerk = clerk;
   }
   @Override
   public void run() {
      System.out.println(getName()+": 开始消费...");
      while (true) {
         try {
            Thread.sleep(15);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         clerk.consumeProduct();
      }
   }
}
public class ProductTest {
   public static void main(String[] args) {
      Clerk clerk = new Clerk();
      Producer p1 = new Producer(clerk);
      p1.setName("生产者");

      Consumer c1 = new Consumer(clerk);
      c1.setName("消费者");
      p1.start();
      c1.start();
   }
}
