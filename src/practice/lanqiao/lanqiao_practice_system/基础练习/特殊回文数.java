package practice.lanqiao.lanqiao_practice_system.基础练习;

import java.util.Scanner;

public class 特殊回文数 {
	public static void main(String[] args) {
		int a1,a2,a3,a4,a5,a6;
		Scanner input =new Scanner(System.in);
		int n = input.nextInt();
		//����λ��
		for(int i=10000;i<=99999;i++) {
			a1=i%10;
			a2=i/10%10;
			a3=i/100%10;
			a4=i/1000%10;
			a5=i/10000%10;
			if(a1+a2+a3+a4+a5==n&&a1==a5&&a2==a4) {
				System.out.println(i);
			}
		}//end for

		for(int i=100000;i<=999999;i++) {
			a1=i%10;
			a2=i/10%10;
			a3=i/100%10;
			a4=i/1000%10;
			a5=i/10000%10;
			a6=i/100000%10;
			if(a1+a2+a3+a4+a5+a6==n&&a1==a6&&a2==a5&&a3==a4) {
				System.out.println(i);
			}
		}//end for
	}
}
