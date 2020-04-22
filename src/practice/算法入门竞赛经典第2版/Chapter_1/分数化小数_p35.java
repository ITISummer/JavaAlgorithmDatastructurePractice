package practice.算法入门竞赛经典第2版.Chapter_1;

import java.util.Scanner;

/**
 * 输入正整数 a,b,c 输出 a/b 的小数形式，精确到小数点后 c 位
 * a,b<=10的6次方 c<=100
 * 输入包含多组数据，结束标记为 a=b=c=0
 * 样例输入：
 * 1 6 4
 * 0 0 0
 * 样例输出：
 * 0.1667
 * 这道题不能用%.cf来使用，只能使用传统的数学方法求余数后乘10再求余数使用C-1次，
 * 同时最后用四舍五入判断第C+1位数是否大于5。
 */
public class 分数化小数_p35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = -1,b = -1,c = -1;
        while (a != 0 && b != 0 && c != 0) {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            if (a == 0 && b == 0 && c == 0) {
                return;
            }
            System.out.printf("%d.",a/b);
            for (int i = 0; i < c - 1; i++) {
                System.out.printf("%d",(a*10/b)%10);
                a = (a*10) % b;
            }
            System.out.printf("%d\n",((a * 100 / b)%100 + 5));


        } //end while
        in.close();
    }


}
