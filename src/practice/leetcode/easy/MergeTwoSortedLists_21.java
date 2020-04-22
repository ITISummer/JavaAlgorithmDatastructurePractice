package practice.leetcode.easy;

/**
 test 1:
 1->2->4, 1->3->4
 1->1->2->3->4->4
 test 2:
 []
 [0]
 */
public class MergeTwoSortedLists_21 {
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

        ListNode  resHead = new ListNode(0);
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
    /**
     *
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * traversal
     * @param l1
     * @param arr
     * @return
     */
    public static ListNode tailInsertByTraversal(ListNode l1, int[] arr) {
        if (l1 == null) {
            l1 = new ListNode(arr[0]);
        }
        ListNode tail = l1;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        tail.next = null;
        return l1;
    }

    /**
     * recursion
     * @param l1
     * @param arr
     * @param index
     * @return
     */
    public static void tailInsertByRecursion(ListNode l1, int[] arr, int index) {
        if (index >= arr.length || index < 0 || l1 == null) {
            return;
        } else {
                l1.next = new ListNode(arr[index++]);
                l1 = l1.next;
            tailInsertByRecursion(l1,arr,index);
        }

    }

    /**
     *
     * @param listNode
     */
    public static void printListNode(ListNode listNode) {
       if (listNode == null) {
           return;
       }
       ListNode temp = listNode;
       while (temp != null) {
           System.out.print(temp.val + " ");
           temp = temp.next;
       }
        System.out.println();
    }



}
