package practice.leetcode.数组.左右指针;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SummerLv
 * @version 2023/11/26 14:23
 * 求解 n Sum 模板
 */
public class Mid_nSum {

    /**
     * @param nums   升序排序后的目标数组
     * @param n      求解 n 数之和
     * @param start  左指针开始的下标
     * @param target 目标和
     * @return
     */
    public static List<List<Integer>> nSum(int[] nums, int n, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();

        if (n == 2) {
            res = twoSum(nums, start, target);
        } else {
            // 递归计算 (n-1)Sum 的结果
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - nums[i]);

                for (List<Integer> list : sub) {
                    list.add(nums[i]);
                    res.add(list);
                }

                // 跳过重复的元素
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }

    /**
     * 两数之和通用化解法（去重）
     *
     * @param nums   有序数组
     * @param start  左指针起始位置
     * @param target 目标值
     * @return
     */
    public static List<List<Integer>> twoSum(int[] nums, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // 记录最初值
            int tmpLeft = nums[left];
            int tmpRight = nums[right];

            if (sum == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                res.add(tmp);
                // 去重
                while (left < right && nums[left] == tmpLeft) left++;
                while (left < right && nums[right] == tmpRight) right--;
            } else if (sum < target) {
                while (left < right && nums[left] == tmpLeft) left++;
            } else {
                while (left < right && nums[right] == tmpRight) right--;
            }
        }
        return res;
    }

}
