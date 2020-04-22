package practice.luogu.数组;

import java.util.Scanner;

// [https://www.luogu.com.cn/problem/P1427]
//测试用例：
    // 3 65 23 5 34 1 30 0
public class P1427小鱼的数字游戏 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[100];
        int length = 0;
        int num = input.nextInt();
        while (true) {
            if (num == 0) {
                break;
            } else {
                numbers[length++] = num;
            } //end if...else
            num = input.nextInt();
        } //end while

        for (int i = length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    } //end main()
}
