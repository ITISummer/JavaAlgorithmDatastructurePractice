package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 是否是闰年 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if((n%4==0&&n%100!=0)||n%400==0) {
			System.out.println("yes");
		}else
			System.out.println("no");
	}
}
