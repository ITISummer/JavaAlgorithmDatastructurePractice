package practice.leetcode.easy;

/**
 * @ClassName NumberOfGoodPairs_1512
 * @Author LCX
 * @Date 2021 2021-06-19 1:06 p.m.
 * @Version 1.0
 **/
public class NumberOfGoodPairs_1512 {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
