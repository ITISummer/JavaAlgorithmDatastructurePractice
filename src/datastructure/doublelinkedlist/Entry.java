package datastructure.doublelinkedlist;

public class Entry {
	//存储数据
		private int data; 
		//存储下一个节点地址
		private Entry next;
		//存储前一个节点的地址
		private Entry pre;
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Entry getNext() {
			return next;
		}
		public void setNext(Entry next) {
			this.next = next;
		}
		public Entry() {
			this(0,null,null);
		}
		public Entry(int data, Entry next, Entry pre) {
			this.data = data;
			this.next = next;
			this.pre = pre;
		}
		public Entry getPre() {
			return pre;
		}
		public void setPre(Entry pre) {
			this.pre = pre;
		}
		
		
		
		
}
