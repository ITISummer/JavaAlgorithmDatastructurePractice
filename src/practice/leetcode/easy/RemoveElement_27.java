package practice.leetcode.easy;

import java.util.Scanner;

public class RemoveElement_27 {
	public static void main(String[] args) {
		int[] nums= {0,1,2,2,3,0,4,2};
		System.out.println("Please input a variable");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int val = input.nextInt();
		System.out.println(removeElement_2(nums,val));
	}// end main()

	/**
	 * 
	 * */
	/*
	 * Test Data:
	 * [3,2,2,3]--2--2
	 * [0,1,2,2,3,0,4,2]--2--5
	 * 
	 */
	public static int removeElement_1(int[] nums, int val) {
		int j=0;
		int i=0;
		while(i<nums.length)
		{
			if(nums[i]!=val)
				nums[j++]=nums[i++];
			else
				i++;
		}//end while
//		for(i=0;i<j;i++) {
//			System.out.print(nums[i]);
//		}//end for
//		System.out.println();
		return j;
	}// end removeElement()
	
	/**
	 * Answer online.
	 * */
	public static int removeElement_2(int[] nums, int val) {
	    int i = 0;
	    for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != val) {
	            nums[i] = nums[j];
	            i++;
	        }
	    }
	    return i;
	}//end removeElement
	
	/**
	 * Answer online.
	 * */
	public static int removeElement_3(int[] nums, int val) {
	    int i = 0;
	    int n = nums.length;
	    while (i < n) {
	        if (nums[i] == val) {
	            nums[i] = nums[n - 1];
	            // reduce array size by one
	            n--;
	        } else {
	            i++;
	        }//end if
	    }//end while
	    return n;
	}//end removeElement()
}// end RemoveElement_27
