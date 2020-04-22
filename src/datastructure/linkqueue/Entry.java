package datastructure.linkqueue;


public class Entry {
	private int data;
	private Entry next;
	public Entry(int data, Entry next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Entry() {
		this(0, null);
	}
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
	
	
	
	
}
