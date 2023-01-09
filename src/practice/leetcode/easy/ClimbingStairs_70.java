package practice.leetcode.easy;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 */
public class ClimbingStairs_70 {
    /**
     * Recursion
     * @param n
     * @return
     */
    public static int climbStairs_1(int n) {
        if(n>=3) {
            return climbStairs_1(n-1)+climbStairs_1(n-2);
        } else if(n==1) {
            return 1;
        }else if(n==2) {
            return 2;
        }
        return 0;
    }

    /**
     * for loop
     * @param n
     * @return
     */
    public static int climbStairs_2(int n) {
        int a = 0;
        int b = 1;
        int temp = b;
        for(int i=1;i<=n;i++) {
            temp = b;
            b = a+b;
            a = temp;
        }
        return b;
    }

    /**
     * hashMap+recursion
     * @param n
     * @return
     */
    public static int climbStairs_3(int n,HashMap<Integer,Integer> hashMap) {
        Integer res = null;
        if((res = hashMap.get(n))!=null) {
            return res;
        } else {
//           return climbStairs_3(n-1,hashMap)+climbStairs_3(n-2,hashMap);
            int a = climbStairs_3(n-2,hashMap);
            int b = climbStairs_3(n-1,hashMap);
            hashMap.put(n,a+b);
            return a+b;
        }
    }
    public static void main(String[] args) {
//        int res = ClimbingStairs_70.climbStairs_1(45);
//        int res = ClimbingStairs_70.climbStairs_2(45);
        HashMap<Integer,Integer> hashMap = new HashMap<>(45);
        hashMap.put(1,1); hashMap.put(2,2);
        int res = ClimbingStairs_70.climbStairs_3(6,hashMap);
        System.out.println(res);
    }
}
