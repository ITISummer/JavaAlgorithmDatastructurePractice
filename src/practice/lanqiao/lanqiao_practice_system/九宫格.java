package practice.lanqiao.lanqiao_practice_system;


import java.util.Scanner;

public class 九宫格 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a[][]=new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				a[i][j]=input.nextInt();
			}//end for
		}//end for
		int b,c,d,e,f,g,h,m;
		b=a[0][0]+a[0][1]+a[0][2];
		c=a[1][0]+a[1][1]+a[1][2];
		d=a[2][0]+a[2][1]+a[2][2];
		e=a[0][0]+a[1][0]+a[2][0];
		f=a[0][1]+a[1][1]+a[2][1];
		g=a[0][2]+a[1][2]+a[2][2];
		h=a[0][0]+a[1][1]+a[2][2];
		m=a[2][0]+a[1][1]+a[0][2];
		if(b==c&&b==d&&b==e&&b==f&&b==g&&b==h&&b==m) {
			System.out.println(1);
		}else
			System.out.println(0);
	}
}
