package practice.luogu.数组;

import java.util.Scanner;

/**
 * 【https://www.luogu.com.cn/problem/P1046】
 测试样例：
 100 200 150 140 129 134 167 198 200 111
 110
 结果：
 5
 */
public class P1046陶陶摘苹果 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] height = new int[10];
        for (int i = 0; i < height.length; i ++) {
            height[i] = input.nextInt();
        }

        int h = input.nextInt();
        int H = h + 30;
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] <= H) {
                result ++;
            } //end if
        } //end for
        System.out.println(result);
    } //end main()
}
