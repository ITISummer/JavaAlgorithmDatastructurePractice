package practice.leetcode.easy;

import practice.leetcode.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = getNumFromList(headA);
        int n = getNumFromList(headB);
        int diff = Math.abs(m-n);
        for (int i = 0; i < diff && m > n; i++) {
            headA = headA.next;
        }
        for (int j = 0; j < diff && n > m; j++) {
            headB = headB.next;
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    /**
     * @param headA
     * @return
     */
    private int getNumFromList(ListNode headA) {
        if(headA == null) {
            return 0;
        }
        int res = 0;
        while (headA != null) {
            res++;
            headA = headA.next;
        }
        return res;
    }

    /**
     * https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linked-list
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
