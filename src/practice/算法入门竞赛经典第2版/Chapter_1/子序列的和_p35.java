package practice.算法入门竞赛经典第2版.Chapter_1;

import java.util.Scanner;

/**
 * 输入两个正整数 n<m<10 的6次方，
 * 输出 1/n2+1/(n+1)2+...+1/m2
 * 保留 5 位小数，输入包含多组数据，结束标记位 n=m=0;
 */
public class 子序列的和_p35 {
    public static void main(String[] args) {
        int n = -1;
        int m = -1;
        Scanner in = new Scanner(System.in);
        while ( n != 0 && m != 0 ) {
            n = in.nextInt();
            m = in.nextInt();
            res(n,m);
        } //end while

    }

    /**
     *
     * @param n
     * @param m
     */
    public static void res(int n, int m) {
        if (n ==0 && m == 0) {
            return;
        }
        double res = 0;
        for (; n <= m; n++) {
            res += 1/(Math.pow(n,2));
        } //end for
        System.out.printf("%.5f",res);
    } //end res()
}
