package datastructure.linkedlooplist;

public class Entry {
	//存储数据
		private int data; 
		//存储下一个节点地址
		private Entry next;
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
			this(0,null);
		}
		public Entry(int data, Entry next) {
			this.data = data;
			this.next = next;
		}
		
		
}
