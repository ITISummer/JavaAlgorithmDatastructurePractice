package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 排列数 {
	private static int a[]=new int[10];
	private static int book[] = new int [10];
	private static int flag=1;
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input =new Scanner(System.in);
		int n=input.nextInt();
		dfs(0,n);
	}
	private static void dfs(int step,int n) {
		int i;
		if(step==10) {
			if(flag==n)
			for(i=0;i<10;i++)
				System.out.print(a[i]);
			flag++;
			return ;
		}//end if
		for(i=0;i<10;i++) {
			if(book[i]==0) {
				a[step]=i;
				book[i]=1;
				dfs(step+1,n);
				book[i]=0;
			}//end if
		}//end for
		return ;
	}//end fun()
}
