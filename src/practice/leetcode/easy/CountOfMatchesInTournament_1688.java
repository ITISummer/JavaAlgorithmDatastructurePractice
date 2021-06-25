package practice.leetcode.easy;

/**
 * @ClassName CountOfMatchesInTournament_1688
 * @Author LCX
 * @Date 2021 2021-06-21 11:28 a.m.
 * @Version 1.0
 **/
public class CountOfMatchesInTournament_1688 {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                res += n;
            } else {
                res += (n - 1) / 2;
                n = n - (n - 1) / 2;
            }
        }
        return res;
    }

    /**
     * solution 2
     */
    public int numberOfMatches_2(int n) {
        if (n == 1) return 0;
        int res = n % 2 == 0 ? n / 2 : (n / 2) + 1;
        return (n / 2) + numberOfMatches(res);
    }
}
