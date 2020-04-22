package practice.luogu.循环循环循环;

import java.util.Arrays;

/**
 * [https://www.luogu.com.cn/problem/P1008]
 */
public class P1008三连击题解 {
    public static void main(String[] args) {
        //第一步初步分析取值范围应该是 [123,987/3]
        int b, c;
        int sum = 0;
        //申明一个置位数组
        int[] bit = new int[10]; //默认初始化为 0
        for (int a = 123; a <= 329; a += 1) {
            Arrays.fill(bit, 0); //每次在使用前初始化数组为 0 ;
            sum = 0;
            b = a << 1; // 等价于 a *= 2
            c = a * 3;
            bit[a % 10] = bit[a / 10 % 10] = bit[a / 100] = bit[b % 10] = bit[b / 10 % 10] = bit[b / 100] = bit[c % 10] = bit[c / 10 % 10] = bit[c / 100] = 1;
            for (int i = 1; i <= 9; i++) {
                sum += bit[i];
            }
            if (sum == 9) {
                System.out.println(a + " " + b + " " + c);
            }
        } //end for
    } //end main()
}
