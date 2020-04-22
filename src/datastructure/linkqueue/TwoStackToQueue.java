package datastructure.linkqueue;

import java.util.LinkedList;

/**
 * 两个栈实现一个队列
 * @author LCX
 *
 */
public class TwoStackToQueue {
	private LinkedList<Integer> s1;
	private LinkedList<Integer> s2;
	
	{
		s1 = new LinkedList<Integer>();
		s2 = new LinkedList<Integer>();
	}
	
	/**
	 * 入队操作，都添加到s1中
	 * @param val
	 */
	public void offer(int val) {
		this.s1.push(val);
	}
	
	/**
	 * 出队列
	 */
	public Integer poll() {
		if (empty()) {
			return null;
		}
		if (this.s2.isEmpty()) {
			//如果s2为空，则把s1中的栈元素全部出栈放入s2中
			while (!this.s1.isEmpty()) {
				this.s2.push(this.s1.pop());
			}
		}
		return this.s2.pop();
	}//end poll()
	
	/**
	 * 查看队头元素
	 * @return
	 */
	public Integer peek() {
		if (empty()) {
			return null;
		}
		if (this.s2.isEmpty()) {
			//如果s2为空，则把s1中的栈元素全部出栈放入s2中
			while (!this.s1.isEmpty()) {
				this.s2.push(this.s1.pop());
			}
		}
		return this.s2.peek();
	}//end peek() 	
	/**
	 * 判空
	 * @return
	 */
	public boolean empty() {
		return this.s1.isEmpty() && this.s2.isEmpty();
	}
	
	public static void main(String[] args) {
		TwoStackToQueue queue = new TwoStackToQueue();
		for (int i = 0; i < 20; i++) {
			queue.offer(i);
		}
		while (!queue.empty()) {
			System.out.print(queue.poll()+" ");
		}
	}
}













