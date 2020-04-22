package practice.luogu.简单字符串;

import java.util.Scanner;

/**
 * 【https://www.luogu.com.cn/problem/P1055】
 * 测试样例：
 *  0-670-82162-4 结果 Right
 *  0-670-82162-0 结果 0-670-82162-4
 */
public class P1055ISBN号码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String isbn = in.nextLine();
        int multiplier = 1;
        int sum = 0;
        for (int i = 0; i < isbn.length() - 2; i++) {
            if (i == 1 || i == 5 || i == 11) {
                continue;
            }
            sum += (multiplier++) * (isbn.charAt(i) - 48);
//            System.out.println(sum);
        } //end for
        int res = sum % 11;
        if ( res+'0' == isbn.charAt(isbn.length()-1)) {
            System.out.println("Right");
        } else {
            char c = res == 10 ? 'X': (char) (res + '0');
            StringBuilder newStr = new StringBuilder(isbn);
            newStr.setCharAt(isbn.length()-1,c);
            isbn = newStr.toString();
            System.out.println(isbn);
        } //end if...else
    } //end main()
}
