package practice.leetcode.easy.array;

/**
 * https://leetcode.com/problems/sqrtx/description/
 */
public class SqrtX_69 {
    public int mySqrt(int x) {
        for (long i = 0; i <= (x / 2)+1; i++) {
            if(i*i <= x && (i+1)*(i+1)>x ) {
                return (int)i;
            }
        }
        return -1;
    }

    public int mySqrt_1(int x) {
        long l = 1, r = x;
        long mid;
        long res = 0;
        while (l<=r) {
            // mid = l+(r-l)/2;
            mid = (l+r)/2;
            if(mid*mid <= x) {
                res = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return (int) res;
    }

    public int mySqrt_2(int x) {
        if(x==0) {
            return 0;
        }
        int i=1;
        //using division instead of multiplication to avoid integer overflow
        for(;i<=x/i;i++)
        {
            if(x/i==i) {
                return i;
            }
        }
        //returning (i-1) because at some point (i*i) became greater than x and loop stopped!!!
        return i-1;
    }

    public int mySqrt_3(int x) {
        return (int) Math.sqrt((int)x);
    }
}
