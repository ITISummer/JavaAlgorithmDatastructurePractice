package datastructure.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 线性表随机存储方式 - 链表 - 带头节点
 * 此类中有实现大数相加和相减的实现方法
 * 链表合并
 * 链表反转-两种方法：1. 对链表进行二次头插法 2. 将链表元素放入栈中
 * 但是大数相减没有实现
 * @author LCX
 */
public class MyLinkedList {
    //指向链表的头节点
    private Entry head;
    private Entry node;
    private Entry last;


    public MyLinkedList() {
        this.head = new Entry();
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.head.getNext() == null;
    }

    /**
     * 单链表头插法
     *
     * @param element
     */
    public void headInsert(int element) {
        //生成一个新节点
        this.node = new Entry(element, null);
        //把新节点的地址设置成原来链表中的第一个节点(不包含头节点)的地址
        this.node.setNext(this.head.getNext());
        //把新节点的地址写入到头节点的地址域中
        this.head.setNext(this.node);
    }

    /**
     * 单链表尾插法
     *
     * @param element
     */
    public void tailInsert(int element) {
        //生成一个新节点
        this.node = new Entry(element, null);
        //找到最后一个节点
        this.last = this.head;
        while (this.last.getNext() != null) {
            this.last = this.last.getNext();
        }
        this.last.setNext(this.node);
        this.last = this.last.getNext();
    }

    /**
     * 查询链表中是否存在指定元素
     *
     * @param element
     * @return
     */
    public boolean query(int element) {
        Entry curEntry = this.head.getNext();
        while (curEntry != null) {
            if (curEntry.getData() == element) {
                return true;
            }
            curEntry = curEntry.getNext();
        }
        return false;
    }//end query()

    /**
     * 删除一个值为element的节点
     *
     * @param element
     */
    public void removeOne(int element) {
        Entry preEntry = this.head;
        Entry curEntry = this.head.getNext();
        while (curEntry != null) {
            if (curEntry.getData() == element) {
                preEntry.setNext(curEntry.getNext());
                curEntry.setNext(null);
                return;
            } else {
                preEntry = curEntry;
                curEntry = curEntry.getNext();
            }//end if...else

        }//end while
    }

    /**
     * 删除值为element的全部节点
     *
     * @param element
     */
    public void removeAll(int element) {
        Entry preEntry = this.head;
        Entry curEntry = this.head.getNext();
        while (curEntry != null) {
            if (curEntry.getData() == element) {
                preEntry.setNext(curEntry.getNext());
                curEntry = preEntry.getNext();
            } else {
                preEntry = curEntry;
                curEntry = curEntry.getNext();
            }//end if...else

        }//end while
    }

    /**
     * 根据头节点打印出链表
     *
     * @param head
     */
    public void printLinkedList(Entry head) {
        Entry moveNode = head.getNext();
        while (moveNode != null) {
            System.out.print(moveNode.getData() + " ");
            moveNode = moveNode.getNext();
        }//end while
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        Entry moveNode = this.head.getNext();
        while (moveNode != null) {
            sBuilder.append(moveNode.getData());
            sBuilder.append(" ");
            moveNode = moveNode.getNext();
        }//end while
        return sBuilder.toString();
    }

    /**
     * 1.单链表逆置-新建单链表-不破坏原链表结构
     * 将已有节点进行头插法二次插入
	 *
     */
    public void reverse() {
        Entry next = null;
        Entry cur = this.head.getNext();

        //清空头节点
        this.head.setNext(null);

        //每次将cur插入head之后
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(this.head.getNext());
            this.head.setNext(cur);
            cur = next;
        }//end while
    }//end reverse()

	/**
	 * 2.使用栈来存储后，再依次出栈
	 */
	public void reverse2() {
		//先初始化一个栈
		Stack<Entry> stack = new Stack<>();
		//遍历当前的链表
		Entry cur = this.head.getNext();
		while (cur != null) {
			//入栈操作
			stack.push(cur);
			cur = cur.getNext();
		} //end while

		//打印栈中元素
		while (stack.size()>0) {
			System.out.println(stack.pop().getData());
		} //end while
	} //end reverse2()

    /**
     * 合并两个带头节点有序单链表
     * @param linkedList2
     */
    public void merge(MyLinkedList linkedList2) {
        //p遍历linklist1节点
        Entry p = this.head.getNext();
        //q遍历linklist2节点
        Entry q = linkedList2.head.getNext();
        //last指向合并后链表的所有节点
        Entry last = this.head;

        while (p != null && q != null) {
            if (p.getData() > q.getData()) {
                //把linklist2上面的节点合并
                last.setNext(q);
                q = q.getNext();
                last = last.getNext();
            } else {
                //把linkelist1上面的节点合并
                last.setNext(p);
                p = p.getNext();
                last = last.getNext();
            }//end if...else
        }//end while

        //最后收尾工作
        if (p != null) {
            last.setNext(p);
        }
        if (q != null) {
            last.setNext(q);
        }

        //最后linkedList2为空
        linkedList2.head.setNext(null);

    }//end merge()

    /**
     * 链表实现两个大数的加法
     */
    public void addLargeNumber() {
        String str1 = "12345678998877777251";
        String str2 = "12345678998877777251";

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        //添加数字各个字符串到链表中--头插法
        for (int i = 0; i < str1.length(); i++) {
            list1.addFirst(str1.charAt(i) - '0');
        }
        for (int i = 0; i < str2.length(); i++) {
            list2.addFirst(str2.charAt(i) - '0');
        }
        //创建迭代器
        Iterator<Integer> it1 = list1.iterator();
        Iterator<Integer> it2 = list2.iterator();

        //处理共同长的部分
        boolean flag = false;
        int left, right, ret;
        while (it1.hasNext() && it2.hasNext()) {
            left = it1.next();
            right = it2.next();

            ret = left + right;
            //有进位待处理
            if (flag) {
                ret += 1;
                flag = false;//进位已经处理
            }//end if

            if (ret >= 10) {
                ret %= 10;
                flag = true;//产生进位的地方
            }//end if
            result.addFirst(ret);
        }//end while

        //处理it1剩余部分
        while (it1.hasNext()) {
            ret = it1.next();
            //有进位待处理
            if (flag) {
                ret += 1;
                flag = false;//进位已经处理
            }//end if

            if (ret >= 10) {
                ret %= 10;
                flag = true;//产生进位的地方
            }//end if
            result.addFirst(ret);
        }//end while
        //处理it2剩余部分
        while (it2.hasNext()) {
            ret = it2.next();
            //有进位待处理
            if (flag) {
                ret += 1;
                flag = false;//进位已经处理
            }//end if

            if (ret >= 10) {
                ret %= 10;
                flag = true;//产生进位的地方
            }//end if
            result.addFirst(ret);
        }//end while

        //处理最后的进位
        if (flag) {
            result.addFirst(1);
        }

//		System.out.println(result.toString());
        for (int val : result) {
            System.out.print(val);
        }

    }//end addLargeNumber()

    /**
     * 实现大数相减
     */
    public void subLargeNumber() {
        String str1 = "12345678998877777";
        String str2 = "12345678998877777251";

        LinkedList<Character> list1 = new LinkedList<>();
        LinkedList<Character> list2 = new LinkedList<>();
        LinkedList<Character> result = new LinkedList<>();

        //处理长度问题
        int len1 = str1.length();
        int len2 = str2.length();
        //添加数字各个字符串到链表中--头插法
        for (int i = 0; i < str1.length(); i++) {
            list1.addFirst(str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            list2.addFirst(str2.charAt(i));
        }
        //创建迭代器
        Iterator<Character> it1 = list1.iterator();
        Iterator<Character> it2 = list2.iterator();


        //处理共同长的部分
        boolean flag = false;//是否借位的标志
        int left, right, ret;
        while (it1.hasNext() && it2.hasNext()) {
            left = it1.next();
            right = it2.next();
            ret = left - right;
            //处理借位
            if (flag) {
                if (left - 1 > right) {
                    ret = left - 1 - right;
                } else {
                    ret = left + 9 - right;
                }
                flag = false;
            }
            if (ret < 0) {
                ret = left + 10 - right;
                flag = true;
            }
            result.addFirst((char) ret);
        }//end while

        // 处理最后的借位-如果最后都借位的话，说明是小的数减去大的数
        if (flag) {
            result.addFirst('-');
        } else if (len1 < len2) {
            result.addFirst('-');
        }//end if...else
    }//end subLargeNumber()


    public static void main(String[] args) {
//		LinkedList linkedList = new LinkedList();
//		for (int i = 1; i <= 10; i++) {
//			linkedList.headInsert(i);
//			linkedList.tailInsert(i);
//		}
//		linkedList.removeOne(3);
//		System.out.println();
//		linkedList.printLinkedList(linkedList.head);
//		linkedList.reverse();
//		System.out.println();
//		linkedList.printLinkedList(linkedList.head);

//		int[] ar = {20,28,37,42,58,69};
//		int[] br = {15,32,35,57};
//		
//		MyLinkedList linkedList1 = new MyLinkedList();
//		MyLinkedList linkedList2 = new MyLinkedList();
//		
//		for (int i : ar) {
//			linkedList1.tailInsert(i);
//		}
//		
//		for (int i : br) {
//			linkedList2.tailInsert(i);
//		}
//		
//		linkedList1.merge(linkedList2);
//		linkedList1.printLinkedList(linkedList1.head);

        MyLinkedList linkedList1 = new MyLinkedList();
        linkedList1.addLargeNumber();


    }


}
