package practice.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Test Case:
 * [1,1,2]
 * [1,1,2,3,3]
 * [1]
 * []
 */
public class RemoveDuplicatesFromSortedList_83 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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
