package datastructure.doublelinkedlist;

/**
 * 
 * @author LCX
 * @date 2019年10月22日
 *
 */
public class DoubleLinkedList {
	//指向双链表第一个节点的头节点
	private Entry head;
	private Entry last;
	
	public DoubleLinkedList() {
		this.head = new Entry();
	}
	
	/**
	 * 实现双向链表头插法
	 * @param element
	 */
	public void headInsert(int element) {
		Entry node = new Entry(element,this.head.getNext(),this.head);
		if (node.getNext() != null) {
			node.getNext().setPre(node);
		}
		this.head.setNext(node);
	}//end headInsert()
	
	/**
	 * 实现双向链表尾插法
	 * @param element
	 */
	public void tailInsert(int element) {
		this.last = this.head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.setNext(new Entry(element, null, last));
	}//end tailInsert()
	
	/**
	 * 移除一个匹配的节点
	 * @param element
	 */
	public void removeOne(int element) {
		Entry cur = this.head.getNext();
		//遍历双向节点，找element节点并删除
		while (cur != null) {
			if (cur.getData() == element) {
				cur.getPre().setNext(cur.getNext());
				if (cur.getNext() != null) {
					cur.getNext().setPre(cur.getPre());
				}
				return;
			}//end if
			cur = cur.getNext();
		}//end while
	}//end removeOne()
	
	
	public static void main(String[] args) {
		DoubleLinkedList dl = new DoubleLinkedList();
		for (int i = 1; i <= 10; i++) {
//			dl.headInsert(i);
			dl.tailInsert(i);
		}//end for
		System.out.println();
	}//end main()
}
