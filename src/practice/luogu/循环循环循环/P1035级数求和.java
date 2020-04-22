package practice.luogu.循环循环循环;

import java.util.Scanner;

/**
 * [https://www.luogu.com.cn/problem/P1035]
 */
public class P1035级数求和 {
    public static void main(String[] args) {
        int n = 1;
        int k = new Scanner(System.in).nextInt();
        for (double Sn = 1; Sn <= k;) {
            ++n;
            Sn += 1.0 / n;
        } //end for
        System.out.println(n);
    } //end main()
}
