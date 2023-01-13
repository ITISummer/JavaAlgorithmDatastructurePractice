package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/single-number/description/
 */
public class SingleNumber_136 {
    /**
     * HashMap
     * @param nums
     * @return
     */
    public static int singleNumber_1(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>(nums.length/2+1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.get(nums[i])!=null) {
                hashMap.put(nums[i],hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i],1);
            }
        }
        for (Integer key: hashMap.keySet()) {
            if(hashMap.get(key)==1) {
                res = key;
            }
        }
        return res;
    }

    /**
     * Sorting
     * @param nums
     * @return
     */
    public static int singleNumber_2(int[] nums) {
//        Arrays.sort(nums);
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length-1; i+=2) {
            if (nums[i]!=nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    /**
     * my quick-sort algorithm
     * @param nums
     */
    private static void quickSort(int[] nums,int low, int high) {
        if(low<high) {
            int pivotPosition = partition(nums,low,high);
            quickSort(nums,low,pivotPosition-1);
            quickSort(nums,pivotPosition+1,high);
        }
    }
    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low<high) {
            while (low < high && nums[high]>=pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low]<=pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    /**
     *  bitwise xor operator
     *  [a^a^a......... (even times)=0
     *  a^a^a........(odd times)=a]
     * @param nums
     */
    public static int singleNumber_3(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int res = singleNumber_2(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}
