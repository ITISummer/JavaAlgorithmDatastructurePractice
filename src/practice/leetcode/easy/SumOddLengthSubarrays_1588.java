package practice.leetcode.easy;

/**
 * @ClassName SumOddLengthSubarrays_1588
 * @Author LCX
 * @Date 2021 2021-06-21 2:53 p.m.
 * @Version 1.0
 **/
public class SumOddLengthSubarrays_1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j <= arr.length - i; j++) {
                for (int k = j; k < i + j; k++) {
                    res += arr[k];
                }
            }
        }
        return res;
    }

    /**
     * solution 2
     */
    public int sumOddLengthSubarrays_2(int[] arr) {
        int sum = 0;
        // traverse the array
        for (int i = 0; i < arr.length; i++) {
            // finding the subarrays with odd length
            sum += ((i + 1) * (arr.length - i) + 1) / 2 * arr[i];
        }
        return sum;
    }
}
