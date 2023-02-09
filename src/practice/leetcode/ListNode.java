package practice.leetcode;

public class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
        public ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
    }
}
