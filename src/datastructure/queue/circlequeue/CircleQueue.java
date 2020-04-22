package datastructure.queue.circlequeue;

/**
 * 循环队列
 * front指向对头元素
 * rear指向队尾元素的后一个位置
 * 队列满的条件 (rear+1) % que.length == front
 * 队列空的条件 rear == front
 * 队列中有效数据个数：(rear+que.length-front) % que.length
 *
 * @author LCX
 */
public class CircleQueue {
    private int[] que;
    private int front;
    private int rear;

    public CircleQueue() {
        this(10);
    }

    public CircleQueue(int size) {
        this.que = new int[size];
        this.front = this.rear = 0;

    }

    /**
     * 判断队空
     *
     * @return
     */
    public boolean empty() {
        return this.rear == this.front;
    } //end empty()

    /**
     * 判断队满
     *
     * @return
     */
    public boolean full() {
        return (this.rear + 1) % this.que.length == this.front;
    } //end full()

    /**
     * 入队列
     *
     * @param val
     */
    public void offer(int val) {
        if (full()) {
            //实现队列扩容
            int[] temp = new int[this.que.length * 2];
            int index = 0;
            //从头到尾遍历旧的队列数组，放入到新数组中
            for (int i = this.front; i != this.rear; i = (i + 1) % this.que.length) {
                temp[index++] = this.que[i];
                //之所以是【i = (i+1)%this.que.length】是因为可能会有循环操作，即这时候rear在front前
                //所以不能是i++
            }
            //重置对头和队尾
            this.front = 0;
            this.rear = index;
            this.que = temp;
        }//end if
        this.que[this.rear] = val;
        this.rear = (this.rear + 1) % this.que.length;

    }

    /**
     * 出队列
     */
    public void poll() {
        if (empty()) {
            return;
        }
        this.front = (this.front + 1) % this.que.length;
    } //end poll()

    /**
     * 查看队头元素
     *
     * @return
     */
    public int peek() throws Exception {
        if (empty()) {
            throw new Exception("queue is empty!");
        }
        return this.que[this.front];
    } //end peek()

    /**
     * 直接显示当前队列元素
     */
    public void showQueue() throws Exception {
        //遍历
        if (empty()) {
            throw new Exception("queue is empty!");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % this.que.length, this.que[i % this.que.length]);
        } //end for

    } //end showQueue()

    /**
     * 返回队列中有效元素个数
     *
     * @return
     */
    public int size() {
        return (this.rear + this.que.length - front) % this.que.length;
    } //end size()

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(25);
        for (int i = 0; i < 20; i++) {
            queue.offer(i);
        }
        //显示当前队列元素
        while (!queue.empty()) {
            int val;
            try {
                val = queue.peek();
                System.out.print(val + " ");
            } catch (Exception e) {
                e.printStackTrace();
            }
            queue.poll();
        }//end while
    }
}




























