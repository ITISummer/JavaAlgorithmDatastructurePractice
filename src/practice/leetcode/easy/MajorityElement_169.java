package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement_169 {
    /**
     * HashMap+Iteration
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i])==null) {
                hashMap.put(nums[i],1);
            } else {
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }
        }
        for(Integer key: hashMap.keySet()){
            if(hashMap.get(key) > nums.length/2){
                return key;
            }
        }
        return 0;
    }


    /**
     * Iteration
     * @param nums
     * @return
     */
    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        int majorityEle = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(cnt==0) {
                majorityEle = nums[i];
            }
            if (majorityEle == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return majorityEle;
    }

    /**
     * Sorting
     * @param nums
     * @return
     */
    public int majorityElement_2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    /**
     * Bit-operation
     */
    public boolean checkBit(int num, int i) {
        return ((num >> i)%2 == 1);
    }
    public int majorityElement_3(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int ele : nums) {
                if(checkBit(ele,i)) {
                    count++;
                }
            }
            if(count > nums.length/2) {
                ans = ans | (1<<i);
            }
        }
        return ans;
    }
}
