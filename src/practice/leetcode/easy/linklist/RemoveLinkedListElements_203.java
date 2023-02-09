package practice.leetcode.easy.linklist;

import practice.leetcode.ListNode;

import javax.management.ListenerNotFoundException;
import java.util.List;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements_203 {
    public static ListNode removeElements(ListNode head, int val) {
          if(head==null) {
              return null;
          }
          ListNode head0 = new ListNode(-1,head);
          ListNode pre = head0;
          ListNode cur = pre.next;
          while(cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
          }
          return head0.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(6,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,null)))))));
        removeElements(head,6);
    }
}
