package practice.leetcode.数组.左右指针;

/**
 * @author SummerLv
 * @version 2023/11/26 12:17
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class Mid_167_TwoSumII_InputArrayIsSorted {
    
    public int[] twoSum(int[] numbers, int target) {
        // 左右指针相向而行
        int left = 0, right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1,right+1};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
    
}
