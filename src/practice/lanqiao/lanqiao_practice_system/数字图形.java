package practice.lanqiao.lanqiao_practice_system;


import java.util.Scanner;
public class 数字图形 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m= input.nextInt();
		char a[]=new char[m];
		a[0]='A';
			for(int j=1;j<m;j++) {
				a[j]=(char) (a[j-1]+1);
			}
		for(int i=0;i<m;i++) {
			for(char v:a)
				System.out.print(v);
			System.out.println();
//			if(i+1==n) {
//				break;
//			}
			for(int j=0;j<=i;j++) {
				a[j]=(char)(a[j]+1);
			}//end for
			for(int k=a.length-1;k>i;k--) {
				a[k]=(char)(a[k]-1);
			}//end for
			
		}//end for
	}
}
