package practice.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 * Test Case:
 * [1,2,3]
 * [4,3,2,1]
 * [9,9]
 * [9]
 * [9,8,9]
 */
public class PlusOne_66 {
    /**
     * Iteration
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i>=0; i--) {
            if(digits[i] != 9) {
                digits[i]+=1;
//                System.out.println(Arrays.toString(digits));
                return digits;
            } else {
               digits[i] = 0;
            }
        }
        digits = new int[digits.length+1];
        digits[0]++;
//        System.out.println(Arrays.toString(digits));
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9};
        PlusOne_66.plusOne(digits);
    }
}
