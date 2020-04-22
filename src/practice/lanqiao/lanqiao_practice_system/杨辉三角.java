package practice.lanqiao.lanqiao_practice_system;

import java.util.Arrays;
import java.util.Scanner;

public class 杨辉三角 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int i,j;
		int a[][]=new int[n][n];
		for(int b[]:a) {
			Arrays.fill(b, 1);
		}
		for(i=2;i<n;i++) {
			for(j=1;j<=i-1;j++) {
					a[i][j]=a[i-1][j]+a[i-1][j-1];
			}//end for
		}//end for
		
		for(i=0;i<n;i++) {
			for(j=0;j<=i;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}//end for
	}//end for
}
