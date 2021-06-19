package practice.leetcode.easy;

/**
 * @ClassName RunningSumOf1dArray_1480
 * @Author LCX
 * @Date 2021 2021-06-19 11:11 a.m.
 * @Version 1.0
 **/
public class RunningSumOf1dArray_1480 {
    public int[] runningSum(int[] nums) {
        int temp = 0;
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] += res[i - 1] + nums[i];
        }
        return res;
    }
}
