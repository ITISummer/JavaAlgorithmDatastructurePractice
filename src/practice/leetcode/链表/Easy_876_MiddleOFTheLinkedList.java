package practice.leetcode.链表;

import practice.leetcode.ListNode;

/**
 * @author SummerLv
 * @version 2023/11/13 21:09
 */
public class Easy_876_MiddleOFTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
