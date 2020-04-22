package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 未名湖 {
	public static long f(long m, long n){
		if(m<n)
			return 0;
		else if(n==0)
			return 1;
		else
			return f(m-1, n) + f(m, n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(f(m, n));

	}

}
