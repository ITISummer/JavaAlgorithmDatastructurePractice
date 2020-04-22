package practice.leetcode.easy;

public class SearchInsertPosition_35 {
	public static void main(String[] args) {
		int []nums = {1,3,5,6};
		System.out.println(searchInsert_2(nums, 0));
	}//end main()
	
	/**
	 * Conventional idea.
	 * sequential search.
	 * */
	/*
	 * Test Data:
	 * Input: [1,3,5,6], 5
	 *	Output: 2
	 *
	 *Input: [1,3,5,6], 2
	 *	Output: 1
	 *
	 *Input: [1,3,5,6], 7
	 *	Output: 4
	 *
	 *Input: [1,3,5,6], 0
	 *	Output: 0
	 * */
public static int searchInsert_1(int[] nums, int target) {
        for(int i =0;i<nums.length;i++) {
        	if(nums[i]==target) {
        		return i;
        	}else {
        		continue;
        	}//end if
        }//end for
        for(int i=0;i<nums.length;i++) {
    		if(target>nums[i]) {
    			continue;
    		}else {
    			return i;
    		}//end if
    	}//end for
	return nums.length;
    }//end searchInsert()

/**
 * Conventional  idea.
 * binary search.
 * */
public static int searchInsert_2(int[] nums, int target) {
	int low = 0;
	int high = nums.length-1;
	int mid = -1;
	int returnInt = -1;
	//Search the array "nums" for the "target" target.
		while(low<=high) {
			mid = (low+high)/2;
			if(target==nums[mid]) {
				returnInt = mid;
				return returnInt;
			}else if(target<nums[mid]) {
				high = mid - 1;
			}else if(target>nums[mid]) {
				low = mid +1;
			}//end if
		}//end while
		
		//Find insert position.
		if(low>high) {
			for(int i=0;i<nums.length;i++) {
	    		if(target>nums[i]) {
	    			continue;
	    		}else {
	    			returnInt = i;
	    			return returnInt;
	    		}//end if
	    	}//end for
		}//end if
	return nums.length;
}//end searchInsert()

}//end  SearchInsertPosition_35
