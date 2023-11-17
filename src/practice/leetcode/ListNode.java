package practice.leetcode;

public class ListNode {
          public int val;
          public ListNode next;
          public ListNode(int x) {
              val = x;
              next = null;
          }
        public ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
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
