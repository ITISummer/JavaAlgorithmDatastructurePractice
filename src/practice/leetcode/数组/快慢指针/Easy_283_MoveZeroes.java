package practice.leetcode.数组.快慢指针;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class Easy_283_MoveZeroes {
    public void moveZeroes_1(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=0) {
                nums[i] = nums[j];
                i++;
            }
        }
        for(int k=i;k<nums.length;k++) {
            nums[k] = 0;
        }
    }

    void moveZeroes_0(int[] nums) {
        int p = removeElement(nums,0);
        for(; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
    /**
     * 使用快慢指针移除指定元素
     * @param nums
     * @param val
     * @return
     */
    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

     public void moveZeroes(int[] nums) {
         for(int i = 0; i<nums.length-1; i++) {
             if(nums[i] == 0) {
                 for(int j = i; j < nums.length-i-1; j++) {
                     int temp = nums[j];
                     nums[j] = nums[j+1];
                     nums[j+1] = temp;
                 }
             }
         }
     }
}
