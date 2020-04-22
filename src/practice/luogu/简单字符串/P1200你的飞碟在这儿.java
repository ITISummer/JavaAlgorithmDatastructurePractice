package practice.luogu.简单字符串;

import java.util.Scanner;

/**
 * 测试数据：
 * COMETQ
 * HVNGAT
 * 输出 ：GO
 *
 * ABSTAR
 * USACO
 * 输出：STAY
 */
public class P1200你的飞碟在这儿 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        int sum = 1;
        int mod = 0;
        for (int i = 0; i < str1.length(); i++) {
            sum *= (str1.charAt(i) - 'A' + 1);
        }
        mod = sum % 47;
        sum = 1;
        for (int i = 0; i < str2.length(); i++) {
            sum *= (str2.charAt(i) - 'A' + 1);
        }

        if (mod == sum % 47) {
            System.out.println("GO");
        } else {
            System.out.println("STAY");
        }

    }
}
