package practice.leetcode.medium.linklist;

/**
 * https://leetcode.cn/problems/design-linked-list/
 */
public class DesignLinkedList_707 {
    int val;
    DesignLinkedList_707 next;
    DesignLinkedList_707 head = new DesignLinkedList_707();
    DesignLinkedList_707 tail = head;

    public DesignLinkedList_707() {
        this.head.val = -1;
        this.head.next = null;
    }
//    public DesignLinkedList_707(int val, DesignLinkedList_707 next) {
//        this.val = val;
//        this.next = next;
//    }

    public int get(int index) {
        int len = 0;
        DesignLinkedList_707 node = head;
        while (node!=null && len <= index) {
            node = node.next;
            len++;
        }
        if(node!=null) {
            return node.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        DesignLinkedList_707 node = new DesignLinkedList_707();
        node.val = val;
        node.next = head.next;
        head.next = node;
    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}
