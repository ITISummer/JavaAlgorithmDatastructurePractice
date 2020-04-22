package practice.luogu.简单字符串;

import java.util.Scanner;

public class P1308统计单词数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        String sentence = in.nextLine();

        int sum = 0; //统计出现次数
        int first = 0; //统计第一次位置
        boolean isContain = false;
        int temp = 0;
        for (int i = 0; i < sentence.length(); i++) {
            //避开空格
            if (sentence.charAt(i) == ' ') {
                continue;
            }
            temp = i; //临时记录 i 的值
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == sentence.charAt(temp ++)) {
                    isContain = true;
                } else {
                    isContain = false;
                    break;
                } //end if...else
            } //end for

            //统计 sum 的值
            if (isContain == true) {
                sum ++;
                if (sum == 1) {
                    first = temp - word.length();
                }
            } //end if
        } //end for
        if (sum != 0) {
            System.out.println(sum+" "+first);
        } else {
            System.out.println(-1);
        }
    } //end main()
}
