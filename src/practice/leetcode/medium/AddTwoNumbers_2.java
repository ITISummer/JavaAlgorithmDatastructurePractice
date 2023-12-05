package practice.leetcode.medium;

import practice.leetcode.ListNode;

import java.util.Scanner;
/*
 * test data:(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * */
public class AddTwoNumbers_2 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the expression:");
		String str = input.nextLine();
		//addTwoNumbers(str);
	}//end main()
	
	/**
	 * 
	 * @param 
	 * @return
	 * 				void
	 * */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}//end addTwoNumbers()

}//end AddTwoNumbers_2
