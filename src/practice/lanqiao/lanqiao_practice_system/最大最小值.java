package practice.lanqiao.lanqiao_practice_system;

import java.util.Arrays;
import java.util.Scanner;

public class 最大最小值 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n=input.nextInt();
		int a[]=new int[n];
		for(int i=0;i<a.length;i++) {
			a[i]=input.nextInt();
		}//end for
		Arrays.sort(a);
		System.out.println(a[a.length-1]+" "+a[0]);
	}
}
