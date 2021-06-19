package practice.leetcode.easy;

/**
 * @ClassName RichestCustomerWealth_1672
 * @Author LCX
 * @Date 2021 2021-06-19 12:38 p.m.
 * @Version 1.0
 **/
public class RichestCustomerWealth_1672 {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int i1 : accounts[i]) {
                sum += i1;
            }
            if (res < sum) {
                res = sum;
            }
        }
        return res;
    }
}
