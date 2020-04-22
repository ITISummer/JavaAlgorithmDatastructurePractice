package practice.luogu.数组;

/**
 * 【https://www.luogu.com.cn/problem/P1428】
 * 测试样例：
 *  6
 * 4 3 0 5 1 2
 * 结果：
 * 0 0 0 3 1 2
 */

import java.util.Scanner;

public class P1428小鱼比可爱 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] fish = new int[n];
        // 循环输入
        for (int i = 0;i < n; i++) {
            fish[i] = input.nextInt();
        }

        int result = 0;
        for (int i = 0;i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (fish[i] > fish[j]) {
                    result ++;
                } //end if
            } //end for
            System.out.print(result+" ");
            result = 0;
        } //end for
    } //end main()

}
