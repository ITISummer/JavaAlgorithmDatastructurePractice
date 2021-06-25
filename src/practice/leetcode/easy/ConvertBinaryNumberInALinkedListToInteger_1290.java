package practice.leetcode.easy;

import java.util.Stack;

/**
 * @ClassName ConvertBinaryNumberInALinkedListToInteger_1290
 * @Author LCX
 * @Date 2021 2021-06-21 3:54 p.m.
 * @Version 1.0
 **/
public class ConvertBinaryNumberInALinkedListToInteger_1290 {
    //  Definition for singly-linked list.
    class ListNode {
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
     * solution 1 - using stack
     */
    public int getDecimalValue(ListNode head) {
        ListNode ptr = head;
        Stack<Integer> stack = new Stack<>();
        while (ptr != null) {
            stack.push(ptr.val);
            ptr = ptr.next;
        }
        int res = 0;
        int exp = 0;
        while (stack.size() > 0) {
            res += stack.pop() << exp++;
        }
        return res;
    }

    /**
     * solution 2 - using String and Integer api
     */
    public int getDecimalValue_2(ListNode head) {
        ListNode ptr = head;
        StringBuilder sb = new StringBuilder();
        while (ptr != null) {
            sb.append(ptr.val);
            ptr = ptr.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

}
