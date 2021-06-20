package practice.leetcode.easy;

/**
 * @ClassName BalancedStringSplit_1221
 * @Author LCX
 * @Date 2021 2021-06-20 11:58 a.m.
 * @Version 1.0
 **/
public class BalancedStringSplit_1221 {
    public int balancedStringSplit(String s) {
        int res = 0;
        int[] count = new int[2];
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == 'R') {
                count[0]++;
            } else {
                count[1]++;
            }
            if (count[0] == count[1]) {
                res++;
            }
        }
        return res;
    }
}
