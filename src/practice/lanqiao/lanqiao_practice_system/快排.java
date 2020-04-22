package practice.lanqiao.lanqiao_practice_system;

import java.util.Arrays;
import java.util.Scanner;

public class 快排 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int [n];
		for(int i=0;i<array.length;i++) {
			array[i]=input.nextInt();
		}//end for
		Arrays.sort(array);
		for(int a:array) {
			System.out.print(a+" ");
		}//end for
	}
}
