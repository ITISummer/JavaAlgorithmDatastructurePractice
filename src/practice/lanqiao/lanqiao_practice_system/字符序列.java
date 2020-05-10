package practice.lanqiao.lanqiao_practice_system;

import java.util.Arrays;
import java.util.Scanner;


public class 字符序列 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int a[] = new int[n];
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = input.nextInt();
			sum += a[i];
		}//end for
		Arrays.sort(a);
		System.out.println(a[a.length-1]);
		System.out.println(a[0]);
		System.out.println(sum);
		
	}
}
