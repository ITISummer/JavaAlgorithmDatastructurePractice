package practice.leetcode.easy;

/**
 * @ClassName XOROperation_1486
 * @Author LCX
 * @Date 2021 2021-06-20 12:10 p.m.
 * @Version 1.0
 **/
public class XOROperation_1486 {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= start + 2 * i;
        }
        return res;
    }
}
