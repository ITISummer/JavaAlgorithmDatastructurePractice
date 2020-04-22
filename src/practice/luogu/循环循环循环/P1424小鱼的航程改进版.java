package practice.luogu.循环循环循环;

import java.util.Scanner;

/**
 * [https://www.luogu.com.cn/problem/P1424]
 */
public class P1424小鱼的航程改进版 {
    public static void main(String[] args) {

        int x,n;
        Scanner input = new Scanner(System.in);
        x = input.nextInt();
        n = input.nextInt();
        int distance = 0;
        for (int i = 1; i <=n ;i ++) {
            if (x % 6 ==0 || x % 7 ==0) {
                if (x == 7) {
                    x = 1;
                    continue;
                }
            } else {
                distance += 250;
            }
            x ++;

        } //end for
        System.out.println(distance);
    } //end main()
}
