package practice.lanqiao.lanqiao_practice_system.基础练习;

import java.util.Scanner;

public class 十六转十进制 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		char cha[] = str.toCharArray();
		long sum=0;
		int temp=0;
		for(int i=0;i<cha.length;i++) {
			switch(cha[i]) {
			case '0':temp=0;break;
			case '1':temp=1;break;
			case '2':temp=2;break;
			case '3':temp=3;break;
			case '4':temp=4;break;
			case '5':temp=5;break;
			case '6':temp=6;break;
			case '7':temp=7;break;
			case '8':temp=8;break;
			case '9':temp=9;break;
			case 'A':temp=10;break;
			case 'B':temp=11;break;
			case 'C':temp=12;break;
			case 'D':temp=13;break;
			case 'E':temp=14;break;
			case 'F':temp=15;break;
			}//end switch
			sum+=Math.pow(16, cha.length-1-i)*temp;
		}//end for
		System.out.println(sum);
	}
}
