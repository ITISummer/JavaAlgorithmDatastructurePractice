package practice.leetcode.easy;

/**
 * @ClassName SubtractProductAndSum_1281
 * @Author LCX
 * @Date 2021 2021-06-19 8:12 p.m.
 * @Version 1.0
 **/
public class SubtractProductAndSum_1281 {
    /**
     * solution 1
     */
    public int subtractProductAndSum(int n) {
        int digit = n % 10;
        int product = 1;
        int sum = 0;
        while (n > 0) {
            n /= 10;
            product *= digit;
            sum += digit;
            digit = n % 10;
        }
        return product - sum;
    }


    public static void main(String[] args) {
        SubtractProductAndSum_1281 obj = new SubtractProductAndSum_1281();
        System.out.println(obj.subtractProductAndSum(4421));
    }
}
