package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 查找整数 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int a[]=new int[n];
		for(int i=0;i<a.length;i++) {
			a[i]=input.nextInt();
		}//end for
		int b=input.nextInt();
		for(int i=0;i<a.length;i++) {
			if(b!=a[i]) {
				continue;
			}else {
				System.out.println(i+1);
				break;
			}
		}//end for
	}
}
