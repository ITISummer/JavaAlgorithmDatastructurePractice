package practice.leetcode.easy;


/**
 * @ClassName ReduceANumberToZero_1342
 * @Author LCX
 * @Date 2021 2021-06-19 10:18 p.m.
 * @Version 1.0
 **/
public class ReduceANumberToZero_1342 {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if ((num % 2) == 0) {
                num /= 2;
            } else {
                num--;
            }
            res++;
        }
        return res;
    }
}
