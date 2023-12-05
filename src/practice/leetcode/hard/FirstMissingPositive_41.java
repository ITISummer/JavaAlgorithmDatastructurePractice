package practice.leetcode.hard;

import java.util.Arrays;

public class FirstMissingPositive_41 {
	public static void main(String[] args) {
		int []nums = {0,2,2,1,1};
		System.out.println(firstMissingPositive(nums));
	}//end main()
	
	/**
	 * 
	 * */
	
	/*
	 * Test Data:
	 * 1. {3,4,-1,1}--2
	 * 2. {7,8,9,11,12}--1
	 * 3. {1,2,0}--3
	 * 4. {0}--1
	 * 5. {1000,-1}--1
	 * 6. {0,2,2,1,1}--3
	 * */
	public static int firstMissingPositive(int[] nums) {
		if (nums == null) {
			return -1;
		} // end if
		int firstPos = -1;// First positive position;
		int misPos = -1;// Missing positive;
		Arrays.sort(nums);
		// Find the position of the first positive number.
		if (nums.length == 0 || nums[0] > 1 || nums[nums.length - 1] < 0) {
			misPos = 1;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] >= 0) {
					firstPos = i;
					if (nums[firstPos] > 1) {
						return 1;
					} else {
						break;
					} // end if
				} else {
					continue;
				} // end if
			} // end for
			
			//Find the missing positive.
			for (; firstPos < nums.length - 1; firstPos++) {
				if (nums[firstPos + 1] - nums[firstPos] > 1) {
					misPos = nums[firstPos] + 1;
					break;
				} else {
					continue;
				} // end if
			} // end for
				// If the firstPos equals last index of the 数组 of "nums".
			if (firstPos == nums.length - 1) {
				misPos = nums[nums.length - 1] + 1;
			} // end if
		} // end if

		return misPos;
	}// end firstMissingPositive()
}//end FirstMissingPositive_41 
