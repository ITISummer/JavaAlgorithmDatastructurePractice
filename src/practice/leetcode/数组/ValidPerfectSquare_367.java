package practice.leetcode.数组;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare_367 {
    /**
     * wrong answer
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num, mid;
        while (l<=r) {
            mid = (l+r)/2;
            if(num/mid == 0) {
                return true;
            } else if(num/mid < mid) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    /**
     * https://leetcode.com/problems/valid-perfect-square/solutions/83907/3-4-short-lines-integer-newton-most-languages/
     * @param num
     * @return
     */
    public boolean isPerfectSquare_1(int num) {
        long r = num;
        while (r*r>num) {
            r = (r+r/num)/2;
        }
        return r*r==num;
    }

    public boolean isPerfectSquare_2(int num) {
        long l = 1, r = num, mid;
        while (l<=r) {
            mid = (l+r)/2;
            if(mid*mid == num) {
                return true;
            }else if (mid*mid < num) {
                l = mid + 1;
            } else {
                r = mid-1;
            }
        }
        return false;
    }

}
