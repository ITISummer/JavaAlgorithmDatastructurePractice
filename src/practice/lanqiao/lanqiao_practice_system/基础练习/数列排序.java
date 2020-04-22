package practice.lanqiao.lanqiao_practice_system.基础练习;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://lx.lanqiao.cn/problem.page?gpid=T52
 * input:
 * 5
 * 8 3 6 4 9
 */
public class 数列排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sort = new int[n];
        for (int i = 0; i < n; i++) {
            sort[i] = in.nextInt();
        }
        Arrays.sort(sort);
        for (int ele: sort) {
            System.out.print(ele+" ");
        }
        in.close();
    }
}
