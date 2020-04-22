package practice.lanqiao.lanqiao_practice_system;


import java.util.Arrays;
import java.util.Scanner;

public class 简单排序 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a[]=new int[3];
		for(int i=0;i<a.length;i++) {
			a[i]=input.nextInt();
		}//end for
		Arrays.sort(a);
		for(int i=a.length-1;i>=0;i--) {
			System.out.print(a[i]+" ");
		}
	}
}
