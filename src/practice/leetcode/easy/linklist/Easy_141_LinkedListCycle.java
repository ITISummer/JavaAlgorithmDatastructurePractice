package practice.leetcode.easy.linklist;

import practice.leetcode.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class Easy_141_LinkedListCycle {
    /**
     * slow and fast pointer
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head,fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null) {
                fast = fast.next;
            }
            if(slow == fast && fast.next != null) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle_2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
