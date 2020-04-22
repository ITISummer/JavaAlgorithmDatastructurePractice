package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum_1 {
	public static void main(String[] args) {
			@SuppressWarnings({ "resource"})
			Scanner input = new Scanner(System.in);
			System.out.println("Please input the array's length:");			
			int length=input.nextInt();
			int []nums=new int[length];
			System.out.println("Please input the array elements:");
			for(int i=0;i<nums.length;i++) {
					nums[i]=input.nextInt();
			}//end for
			System.out.println("Please input the target:");
			int target=input.nextInt();
			System.out.println(Arrays.toString(twoSum_2(nums,target)));
	}// end main()

/**
 * The brute force approach
 * @author summer
 *@param
 *	
 * */
	public static int[] twoSum_0(int[] nums, int target) {
		int i, j; // index
		for (i = 0; i < nums.length; i++) {
			for (j = i+1; j < nums.length; j++) {
				if (target - nums[j] == nums[i]) {
					return new int[] {i,j};
				} // end if
			} // end for
		} // end for
		 throw new IllegalArgumentException("No two sum solution");
	}// end twoSum()


/**
 * Two-pass Hash Table
 *@return
 *					Returns an array of integers 
 *@param
 *	
 * */
	public static int[] twoSum_1(int[] nums, int target) {
		//Create a HashMap object.
		Map <Integer,Integer>hashMap = new HashMap<Integer,Integer>();
		//Create a hash table by using  a  for loop
		for(int i=0;i<nums.length;i++) {
			hashMap.put(nums[i],i);
		}//end for
		
		for(int i=0;i<nums.length;i++) {
			int complement = target-nums[i];
			//if the  complement is in the map and the key of  the complement is not equals  to i
			if(hashMap.containsKey(complement)&&hashMap.get(complement)!=i) {
				return new int[] {i,hashMap.get(complement)};
			}//end if
		}//end for
		 throw new IllegalArgumentException("No two sum solution");
	}// end twoSum()

	/**
	 * One-pass Hash Table
	 *@return
	 *					Returns an array of integers 
	 *@param
	 *	
	 * */
	public static int[] twoSum_2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] {
	             map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
}// end TwoSum_1
