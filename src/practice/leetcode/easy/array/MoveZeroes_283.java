package practice.leetcode.easy.array;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeroes_283 {
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
