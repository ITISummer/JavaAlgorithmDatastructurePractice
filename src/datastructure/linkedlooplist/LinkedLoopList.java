package datastructure.linkedlooplist;


/**
 * 线性表随机存储方式 - 链表 - 带头节点
 * 单项循环链表
 * @author LCX
 *
 */
public class LinkedLoopList {
	//指向链表的头节点
	private Entry head;
	private Entry node;
	private Entry last;
	
	
	public LinkedLoopList() {
		this.head = new Entry();
		//头节点的地址的next域指向自身
		this.head.setNext(this.head);
	}
	
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return this.head.getNext() == this.head;
	}
	
	/**
	 * 单链表头插法
	 * @param element
	 */
	public void headInsert(int element) {
		//生成一个新节点
		this.node = new Entry(element,null);
		//把新节点的地址设置成原来链表中的第一个节点(不包含头节点)的地址
		this.node.setNext(this.head.getNext());
		//把新节点的地址写入到头节点的地址域中
		this.head.setNext(this.node);
	}
	
	/**
	 * 单链表尾插法
	 * @param element
	 */
	public void tailInsert(int element) {
		//生成一个新节点，在生成的时候已经指定了下一个节点是head节点
		this.node = new Entry(element,this.head); 
		//找到最后一个节点
		this.last = this.head;
		//末尾节点的特征是，头节点存储的是head结点的地址
		while (this.last.getNext() != this.head) {
			this.last = this.last.getNext();
		}
		this.last.setNext(this.node);
		this.last = this.last.getNext();
	}
	
	/**
	 * 查询链表中是否存在指定元素
	 * @param element
	 * @return
	 */
	public boolean query(int element) {
		Entry curEntry = this.head.getNext();
		while (curEntry != head) {
			if (curEntry.getData() == element) {
				return true;
			}
			curEntry = curEntry.getNext();
		}
		return false;
	}//end query()

	/**
	 * 删除一个值为element的节点
	 * @param element
	 */
	public void removeOne(int element) {
		Entry preEntry = this.head;
		Entry curEntry = this.head.getNext();
		while (curEntry != this.head) {
			if (curEntry.getData() == element) {
				preEntry.setNext(curEntry.getNext());
				curEntry.setNext(null);
				return;
			}else {
				preEntry = curEntry;
				curEntry = curEntry.getNext();
			}//end if...else
			
		}//end while
	}
	
	/**
	 * 删除值为element的全部节点
	 * @param element
	 */
	public void removeAll(int element) {
		Entry preEntry = this.head;
		Entry curEntry = this.head.getNext();
		while (curEntry != this.head) {
			if (curEntry.getData() == element) {
				preEntry.setNext(curEntry.getNext());
				curEntry = preEntry.getNext();
			}else {
				preEntry = curEntry;
				curEntry = curEntry.getNext();
			}//end if...else
			
		}//end while
	}
	/**
	 * 根据头节点打印出链表
	 * @param head
	 */
	public void printLinkedList(Entry head) {
		Entry moveNode = head.getNext();
		while (moveNode != this.head) {
			System.out.print(moveNode.getData() + " ");
			moveNode = moveNode.getNext();
		}//end while
	}
	
	/**
	 * 
	    * @Title: josephRingShow
	    * @Description: TODO(显示约瑟夫环出列的序号)
	    * @param @param k	从序号为 k 的人开始报数
	    * @param @param m   报数的次数
	    * @return void    返回类型
	    * @throws
	 */
	public void josephRingShow(int k, int m) {
		Entry pre = this.head;
		Entry cur = this.head.getNext();
		
		//让cur指向第k个人
		while (k-- > 1) {
			pre = cur;
			cur = cur.getNext();
		}
		
		//循环进行报数，然后出列
		while (true) {
			if (this.head.getNext() == this.head) {
				//链表为空，所有人出列
				return;
			}
			
			//报数之前也得检查是否指向有效的k值
			if (cur == this.head) {
				pre = cur;
				cur = cur.getNext();
			}//end if
			
			//数m次
			for (int i = 1; i < m; i++) {
				pre = cur;
				cur = cur.getNext();
				if (cur == this.head) {
					pre = cur;
					cur = cur.getNext();
				}//end if
			}//end for
			
			//cur 出列，出列后删除cur节点
			System.out.println(cur.getData()+"出列！");
			pre.setNext(cur.getNext());
			cur = pre.getNext();
		}//end while
	}
	
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		Entry moveNode = head.getNext();
		while (moveNode != this.head) {
			sBuilder.append(moveNode.getData());
			sBuilder.append(" ");
			moveNode = moveNode.getNext();
		}//end while
		return sBuilder.toString();
	}
	
	
	
	public static void main(String[] args) {
		LinkedLoopList linkedList = new LinkedLoopList();
		for (int i = 0; i < 10; i++) {
			linkedList.headInsert(i);
//			linkedList.tailInsert(i);
		}
//		linkedList.removeOne(3);
//		System.out.println();
		linkedList.printLinkedList(linkedList.head);
		System.out.println();
		System.out.println(linkedList.toString());
//		linkedList.printLinkedList(linkedList.head);
		
	}

	
	
	
	
}

