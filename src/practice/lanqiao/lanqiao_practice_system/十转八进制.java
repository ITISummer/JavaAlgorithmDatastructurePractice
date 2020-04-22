package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 十转八进制 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		fun(input.nextInt());
	}
	private static void fun(int n) {
		if(n>=8) {
			fun(n/8);
			System.out.print(n%8);
		}else {
			System.out.print(n%8);
		}
		
	}//end fun()
}
