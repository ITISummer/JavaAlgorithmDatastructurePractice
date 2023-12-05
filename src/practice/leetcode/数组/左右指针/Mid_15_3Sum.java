package practice.leetcode.数组.左右指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SummerLv
 * @version 2023/11/26 12:58
 * https://leetcode.cn/problems/3sum/description/
 */
public class Mid_15_3Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums, 0);
        System.out.println(lists);
    }
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < sortedNums.length; i++) {
            List<List<Integer>> tuple2 = twoSum(sortedNums,i+1,target - sortedNums[i]);

            for (List<Integer> list : tuple2) {
                list.add(sortedNums[i]);
                res.add(list);
            }
            
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < sortedNums.length - 1 && sortedNums[i] == sortedNums[i+1]) i++;
        }
        return res;
    }

    /**
     * 两数之和通用化解法（去重）
     * @param nums 有序数组
     * @param start 左指针起始位置
     * @param target 目标值
     * @return
     */
    public static List<List<Integer>> twoSum(int[] nums, int start,int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start, right = nums.length-1;
        while (left < right) {
            int sum = nums[left]+nums[right];
            // 记录最初值
            int tmpLeft = nums[left];
            int tmpRight = nums[right];
            
            if(sum == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                res.add(tmp);
                // 去重
                while (left < right && nums[left] == tmpLeft) left++;
                while (left < right && nums[right] == tmpRight) right--;
            } else if(sum < target) {
                while (left < right && nums[left] == tmpLeft) left++;
            } else {
                while (left < right && nums[right] == tmpRight) right--;
            }
        }
        return res;
    }
}
