package practice.leetcode.链表;

import practice.leetcode.ListNode;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Test Case:
 * [1,1,2]
 * [1,1,2,3,3]
 * [1]
 * []
 */
public class Easy_83_RemoveDuplicatesFromSortedList {

    /**
     * Iteration
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates_1(ListNode head) {
        ListNode p = head;
        ListNode q = p;
        while (p != null) {
            q = p.next;
            if (q != null && p.val == q.val) {
                p.next = q.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if(fast.val != slow.val) {
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        // 断开与后面元素的连接
        slow.next = null;
        return head;
    }

    /**
     * HashSet+Iteration
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates_2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = p.next;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(p.val);
        while (q != null) {
            q = p.next;
            if (q != null) {
                if (hashSet.contains(q.val)) {
                    p.next = q.next;
                } else {
                    hashSet.add(q.val);
                    p = q;
                }
            }
        }
        return head;
    }
}
