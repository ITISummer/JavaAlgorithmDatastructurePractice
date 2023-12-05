package practice.leetcode.数组;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfASortedArray_977 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares_1(int[] nums) {
        int neg = 0;
        int temp1,temp2,k,j,index=0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                neg = i;
            } else {
                break;
            }
        }

        for(k = neg,j = neg+1;k>=0 && j<nums.length;) {
            temp1 = nums[k]*nums[k];
            temp2 = nums[j]*nums[j];
            if(temp1<=temp2) {
                res[index++] = temp1;
                k--;
            } else {
                res[index++] = temp2;
                j++;
            }
        }
        while (k>=0) {
            res[index++] = nums[k]*nums[k];
            k--;
        }
        while (j<nums.length) {
            res[index++] = nums[j]*nums[j];
            j++;
        }
        return res;
    }

    public int[] sortedSquares_2(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0,j=nums.length-1,index = nums.length-1;i<=j;) {
            if(nums[i]*nums[i]<=nums[j]*nums[j]) {
                res[index--] = nums[j]*nums[j];
                j--;
            } else {
                res[index--] = nums[i]*nums[i];
                i++;
            }
        }
        return res;
    }
}
