package datastructure.linkqueue;


/**
 * 链式队列
 * @author LCX
 *
 */
public class LinkQueue {
	//指向链表头节点
	private Entry front;
	//指向链表尾节点
	private Entry rear;
	
	/**
	 * 初始化一个链式队列
	 */
	public LinkQueue() {
		this.front = this.rear = new Entry();
	}
	
	
	/**
	 * 入队操作
	 * @param val
	 */
	public void offer(int val) {
		Entry node = new Entry(val,null);
		this.rear.setNext(node);
		this.rear = node;
	}//end offer()
	
	/**
	 * 出队
	 * @return
	 */
	public void poll() {
		if (empty()) {
			return;
		}
		this.front.setNext(this.front.getNext().getNext());
		//删除队列的最后一个节点，需要把rear指向队头
		if (this.front.getNext() == null) {
			this.rear = this.front;
		}
		
	}//end poll()
	
	/**
	 * 返回对头的值
	 * @return
	 */
	public int peek() throws Exception{
		if (empty()) {
			throw new Exception("queue is empty!");
		}
		return this.front.getNext().getData();
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean empty() {
		return this.front == this.rear;
	}
	
	public static void main(String[] args) {
		LinkQueue queue = new LinkQueue();
		for (int i = 0; i < 20; i++) {
			queue.offer(i);
		}
		while (!queue.empty()) {
			try {
			int val = queue.peek();
				System.out.print(val+" ");
			} catch (Exception e) {
				e.printStackTrace();
			}
			queue.poll();
		}//end while
	}
	
	
}
