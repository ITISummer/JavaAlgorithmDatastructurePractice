package practice.luogu.数组;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [https://www.luogu.com.cn/problem/P2141]
 * 测试样例：
 *  4
 * 1 2 3 4
 * 结果：
 *  2
 */
public class P2141珠心算测验 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        //循环读入
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        //因为数字不同，则进行排序先，默认从小到大排序
        Arrays.sort(arr);
        int result = 0;
        int temp = 0;
        //然后开始从下标 0 开始，往后计算
        for (int i = 0; i < arr.length-1; i++) {
            for (int k = i + 1; k < arr.length - i; k++) {
                temp = arr[i] + arr[k];
                for (int j = k + 1;j < arr.length;j++) {
                    if (temp == arr[j]) {
                        result ++;
                    } //end if
                } //end for
            } //end for
        } //end for
        System.out.println(result);
    } //end main()
}
