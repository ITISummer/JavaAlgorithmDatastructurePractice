package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 路径最大值 {
	public static void main(String[] args) {
		int n;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				a[i][j] = s.nextInt();
			}
		}//end for
		for(int i = n - 1; i >= 0; i--)
			for(int j = 0; j <= i; j++)
				getBest(a, i, j);
		System.out.println(a[0][0]);
	}

	static void getBest(int[][] arr, int i, int j) {
		if (i == arr.length - 1)          //if it's the last line
			return;
		else{
			arr[i][j] = getMax(arr[i][j] + arr[i + 1][j], arr[i][j] + arr[i + 1][j + 1]);
		}
	}

	static int getMax(int n1, int n2) {
		if (n1 > n2)
			return n1;
		else
			return n2;
	}
}
