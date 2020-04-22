package practice.lanqiao.lanqiao_practice_system;

import java.util.Arrays;
import java.util.Scanner;

public class 找出第二大整数 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a[]=new int[21];
		int b[];
		int n=input.nextInt();
		int i=0;
		while(n!=0) {
			a[i++]=n;
			n=input.nextInt();
		}//end while
		b=new int[i];
		for(int j=0;j<b.length;j++) {
			b[j]=a[j];
		}
		System.out.println(a.length);
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
		System.out.println(b.length);
		System.out.println(b[b.length-2]);
	}
}
