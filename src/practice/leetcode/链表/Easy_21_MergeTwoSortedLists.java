package practice.leetcode.链表;

import practice.leetcode.ListNode;

import static practice.leetcode.ListNode.*;

/**
 输入：l1 = [1,2,4], l2 = [1,3,4]
 输出：[1,1,2,3,4,4]
 示例 2：

 输入：l1 = [], l2 = []
 输出：[]
 示例 3：

 输入：l1 = [], l2 = [0]
 输出：[0]

 https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class Easy_21_MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,4};
        ListNode l1 = new ListNode(arr1[0]);
        ListNode l2 = new ListNode(arr2[0]);
        l1 = tailInsertByTraversal(l1,arr1);
        printListNode(l1);
        //--------------------------------
        tailInsertByRecursion(l2,arr2,1);
        printListNode(l2);

        ListNode l3 = mergeTwoLists(l1,l2);
        printListNode(l3);
    }

    /**
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        ListNode  resHead = new ListNode(-1);
        ListNode  resTail = resHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                resTail.next = l1;
                l1 = l1.next;
            } else {
                resTail.next = l2;
                l2 = l2.next;
            }
            resTail = resTail.next;
        }
        resTail.next = (l1 != null ? l1 : l2);
        return resHead.next;
    }
    

}
