package practice.算法入门竞赛经典第2版.Chapter_1;

import java.util.Scanner;

/**
 * 韩信点兵：
 * 韩信让士兵 三人一排，五人一排，七人一排变换队形
 * 每次只掠一眼排尾就知道总人数，输入数据：
 * 每组数据包含 3 个非负整数 a,b,c 表示每种队形的排尾人数
 * (a < 3, b < 5, c < 7)
 * 输出总人数的最小值，或者报告无解
 * 已知总人数 10<=num<=100
 *
 * 样例输入：
 * 2 1 6
 * 2 1 3
 * 样例输出：
 * 41
 * No answer
 */
public class 韩信点兵_p34 {
    public static void main(String[] args) {
        int a,b,c;
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        in.close();
        res(a,b,c);
    } //end main()

    /**
     *
     * @param a
     * @param b
     * @param c
     */
    public static void res(int a, int b, int c) {
        boolean haveRes = false;
        for (int i = 10; i <= 100; i++) {
            if (i % 3 == a && i % 5 == b && i % 7 == c) {
                haveRes = true;
                System.out.println(i);
                break;
            }
        } //end for
        if (!haveRes) {
            System.out.println("No answer");
        }
    } //end res()
}
