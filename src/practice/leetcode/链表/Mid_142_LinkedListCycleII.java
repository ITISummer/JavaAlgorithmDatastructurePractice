package practice.leetcode.链表;

import practice.leetcode.ListNode;

/**
 * @author SummerLv
 * @version 2023/11/15 20:20
 */
public class Mid_142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast=head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        
        if(fast == null || fast.next == null) return null;
        
        // slow 重新指向头结点，或者 fast 重新指向头结点
        slow = head;
        
        // 快慢指针同步前进
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
