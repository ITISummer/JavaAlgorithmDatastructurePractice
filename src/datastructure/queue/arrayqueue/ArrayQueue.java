package datastructure.queue.arrayqueue;

import java.util.Scanner;

/**
 * front指向对头前一个位置
 * rear指向队尾元素
 */
public class ArrayQueue {
    private int maxSize;//队列最大长度
    private int front; //队列头指针（不包含队头有效元素）
    private int rear; //队列尾指针（包含队列尾部有效元素）
    private int[] arr;//存放数据

    /**
     * 根据传入的值初始化队列的大小
     *
     * @param maxSize
     */
    ArrayQueue(int maxSize) {
        //需要判断传入的值是否合法
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
        this.front = this.rear = -1;
    } //end ArrayQueue()

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    } //end isFull()

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    } //end isEmpty()

    /**
     * 添加元素
     *
     * @param n
     */
    public void addQueue(int n) {
        //判断n是否合法和队列是否已满
        if (isFull()) {
            System.out.println("队列已满！");
            return;
        }
        this.arr[++this.rear] = n;
    } //end addQueue()

    /**
     * 出队列
     *
     * @return
     */
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        }
        return this.arr[++this.front];
    } //end poll()

    /**
     * 显示队列所有数据
     */
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列空！");
            return;
        }
        for (int i = this.front+1; i <= this.rear; i++) {
            System.out.printf("arr[%d] = [%d]\n", i, arr[i]);
        } //end for
    } //end showQueue()

    /**
     * 显示对头元素
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        }
        return this.arr[this.front + 1];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        Scanner input = new Scanner(System.in);
        queue.addQueue(input.nextInt());
        queue.addQueue(input.nextInt());
        queue.addQueue(input.nextInt());

        queue.showQueue();

        System.out.println();
        queue.poll();
        queue.showQueue();
    } //end main()

}
