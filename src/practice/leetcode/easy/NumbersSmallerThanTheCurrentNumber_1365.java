package practice.leetcode.easy;

import java.util.*;

/**
 * @ClassName NumbersSmallerThanTheCurrentNumber_1365
 * @Author LCX
 * @Date 2021 2021-06-19 2:28 p.m.
 * @Version 1.0
 **/
public class NumbersSmallerThanTheCurrentNumber_1365 {
    /**
     * solution of mine
     * O(n^2) solution, compare each element to every other element
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    /**
     * O(nlogn) solution - sort and use index to count
     * [ava | O(n^2). O(nlogn), and O(n) solution](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/1279993/Java-or-O(n2).-O(nlogn)-and-O(n)-solution)
     */
    public int[] smallerNumbersThanCurrent_1(int[] nums) {

        List<Integer> sorted = new ArrayList<>();
        //O(n) - convert 数组 to List
        for (int i : nums) {
            sorted.add(i);
        }
        // O(nlogn) - sort List
        Collections.sort(sorted);

        // O(n) - store lowest index of each number in the sorted list
        Map<Integer, Integer> lowestIndexMap = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            if (!lowestIndexMap.containsKey(sorted.get(i)))
                lowestIndexMap.put(sorted.get(i), i);
        }
        //O(n)
        int[] smaller = new int[nums.length];
        for (int i = 0; i < smaller.length; i++) {
            smaller[i] = lowestIndexMap.get(nums[i]);
        }
        return smaller;
    }

    /**
     * O(n) optimized using the constraints of min value [0,100]
     * [ava | O(n^2). O(nlogn), and O(n) solution](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/1279993/Java-or-O(n2).-O(nlogn)-and-O(n)-solution)
     */
    public int[] smallerNumbersThanCurrent_2(int[] nums) {
        // Stores count of each element in nums
        // O(1) space
        // 0 to 100. The possible numbers are represented by the indices. The element value is their count
        int[] numberCount = new int[101];
        // O(n) space
        int[] result = new int[nums.length];

        // O(n) time - Count each Number appearance in nums
        for (int i = 0; i < nums.length; i++) {
            numberCount[nums[i]] = numberCount[nums[i]] + 1;
        }

        // O(n) time - count appearance of numbers less than each element
        for (int i = 0; i < nums.length; i++) {
            int totalLesser = 0;
            // O(1) time (doesn't care about input size)
            for (int j = 0; j < nums[i]; j++) {
                totalLesser += numberCount[j];
            }
            result[i] = totalLesser;
        }
        return result;
    }
}
