package datastructure.stack;

import java.util.Arrays;

/**
 * 实现顺序栈-数组
 * 栈顶指针初始化为0
 * @author LCX
 *
 */
public class SeqStack {
	private int[] stack;//栈列
	private int top;//栈顶指针
	
	public SeqStack() {
		this(10);
	}
	
	public SeqStack(int size) {
		this.stack = new int[size];
		this.top = 0;
	}
	
	/**
	 * 入栈操作
	 * @param val
	 */
	public void push(int val) {
		if (full()) {
			//进行二倍扩容操作
			this.stack = Arrays.copyOf(this.stack, this.stack.length*2);
		}
		this.stack[this.top] = val;
		this.top++;
	}//end push()
	
	/**
	 * 出栈操作
	 */
	public void pop() {
		if (empty()) {
			return;
		}
		this.top--;
	}
	
	/**
	 * 查看栈顶元素
	 * @return
	 */
	public int peak() {
		return this.stack[this.top-1];
	}
	
	/**
	 * 判断栈满
	 * @return
	 */
	public boolean full() {
		return this.top == this.stack.length;
	}//end full()
	
	/**
	 * 判断栈空
	 * @return
	 */
	public boolean empty() {
		return this.top == 0;
	}//end empty()
	
	public static void main(String[] args) {
		SeqStack seqStack = new SeqStack();
		for (int i = 0; i < 20; i++) {
			seqStack.push(i);
		}
		while (!seqStack.empty()) {
			int val = seqStack.peak();
			System.out.print(val+" ");
			seqStack.pop();
		}
	}
}
