package practice.leetcode.easy.linklist;

import practice.leetcode.ListNode;

/**
 * @author SummerLv
 * @version 2023/11/13 20:41
 * 
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 */
public class Mid__19_Remove_Nth_Node_From_End_OF_List {
    public ListNode findFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        while (fast!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode tmp = findFromEnd(dummy,n+1);
        
        tmp.next = tmp.next.next;
        return dummy.next;
    }
}
