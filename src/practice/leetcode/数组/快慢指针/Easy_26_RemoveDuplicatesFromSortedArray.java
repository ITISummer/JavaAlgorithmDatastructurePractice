package practice.leetcode.数组.快慢指针;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 */
public class Easy_26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }//end main()


    /*
     * Test Data:
     * [1,1,2]--2
     * [0,0,1,1,1,2,2,3,3,4]--5
     * */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int slow = 0;
        int fast = 0;
        
        while (fast < nums.length) {
            if (nums[slow] != nums[fast])
                nums[++slow] = nums[fast];
            fast++;
        }
        return slow + 1;
    }

}//end RemoveDuplicatesFromSortedArray_26
