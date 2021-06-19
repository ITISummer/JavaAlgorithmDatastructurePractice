package practice.leetcode.easy;

/**
 * @ClassName ShuffleTheArray_1470
 * @Author LCX
 * @Date 2021 2021-06-19 12:08 p.m.
 * @Version 1.0
 **/
public class ShuffleTheArray_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[i * 2] = nums[i];
            res[i * 2 + 1] = nums[n + i];
        }
        return res;
    }
}
