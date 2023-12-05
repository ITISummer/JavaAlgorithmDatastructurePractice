package practice.leetcode.链表;

import practice.leetcode.ListNode;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Easy_160_IntersectionOfTwoLinkedLists {
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


    /**
     * 和 getIntersectionNode_2 一样思路只不过换一种写法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if(p1 == null)
                p1 = headB;
            else
                p1 = p1.next;
            
            if(p2 == null)
                p2 = headA;
            else
                p2 = p2.next;
        }
       return p1;
    }


    /**
     * 使用 HashSet 判断
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_4(ListNode headA, ListNode headB) {
        ListNode tmp = headA;
        HashSet<ListNode> hashSet = new HashSet<>();
        while (tmp != null) {
            hashSet.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            if(hashSet.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        
        return null;
    }
}
