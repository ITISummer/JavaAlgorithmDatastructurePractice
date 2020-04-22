package practice.luogu.数组;

import java.util.Scanner;

/**
 * 【https://www.luogu.com.cn/problem/P1567】
 * 10
 * 1 2 3 2 4 5 6 8 5 9
 *
 * 结果：5
 */
public class P1567统计天数 {
    public static void main(String[] args) {
        int max = 0; //记录最大值
        int pre = Integer.MIN_VALUE; //记录前一个输入的值
        int nex; //记录后一个输入的值
        int length = 0; //要输入的长度
        int res = max; //要输出的结果
        Scanner in = new Scanner(System.in);
        length = in.nextInt();
        for (int i = 1; i <= length; i++) {
            nex = in.nextInt();
            if (nex > pre) {
                max ++;
            } else {
               res = Math.max(max,res);
                max = 1;
            } //end if...else
            pre = nex;
        } //end for
        System.out.println(res);
        in.close();
    } //end main()
}
