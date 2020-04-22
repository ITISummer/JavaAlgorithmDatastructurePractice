package datastructure.linkqueue;

/**
 * 两个队列实现一个java栈
 * @author LCX
 *
 */
public class TwoQueueToStack {
	private LinkQueue queue1;
	private LinkQueue queue2;
	{
		this.queue1 = new LinkQueue();
		this.queue2 = new LinkQueue();
	}
	
	/**
	 * 入栈操作
	 * @param val
	 */
	public void push(int val) {
		if (!queue1.empty()) { //queue1 不为空，则queue1 入队
			queue1.offer(val);
		}else if (!queue2.empty()) {//queue2不为空，则queue2 入队
			queue2.offer(val);
		}else {//queue1 入队
			queue1.offer(val);
		}//end if
	}//end push()
	
	/**
	 * 判断当前两个队列是否为空
	 * @return
	 */
	public boolean empty() {
		return this.queue1.empty() && this.queue2.empty();
	}
	
	public Integer pop() {
		if (empty()) {
			return null;
		}//如果这里为空，则会抛出类型转换错误的异常
		
		LinkQueue srcQueue = this.queue1;
		LinkQueue desQueue = this.queue2;
		
		if (srcQueue.empty()) {
			srcQueue = this.queue2;
			desQueue = this.queue1;
		}
		
		int data = 0;
		while (!srcQueue.empty()) {
			try {
				data = srcQueue.peek();
				srcQueue.poll();
				if (srcQueue.empty()) {
					break;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			desQueue.offer(data);
			
		}//end while
		
		return data;
	}//end pop
	
	public static void main(String[] args) {
		TwoQueueToStack stack = new TwoQueueToStack();
		for (int i = 0; i < 20; i++) {
			stack.push(i);
		}
		
		while (!stack.empty()) {
			System.out.print(stack.pop()+" ");
		}//end while
	}//end main()
}
