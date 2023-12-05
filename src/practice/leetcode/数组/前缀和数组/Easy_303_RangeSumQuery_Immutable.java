package practice.leetcode.数组.前缀和数组;

/**
 * @author SummerLv
 * @version 2023/11/27 20:32
 * https://leetcode.cn/problems/range-sum-query-immutable/
 */
public class Easy_303_RangeSumQuery_Immutable {
    // 前缀和数组
    private int[] preSum;
    
    public Easy_303_RangeSumQuery_Immutable(int[] nums) {
        preSum = new int[nums.length+1];
        for(int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1]+nums[i-1];
        }
    }
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}
