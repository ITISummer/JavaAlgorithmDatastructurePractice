package practice.算法入门竞赛经典第2版.Chapter_1;

import java.util.Scanner;

/**
 * 输入正整数 n <= 20 输出一个 n 层的倒三角形
 */
public class 倒三角形_p34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        printTriangle(n);
    }

    /**
     * 打印倒三角
     * @param n
     */
    public static void printTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * n - (2 * i + 1); k++) {
                System.out.print("#");
            }
            System.out.println();
        } //end for
    } //end printTriangle()

}
