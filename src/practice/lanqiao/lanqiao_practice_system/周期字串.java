package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 周期字串{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str=input.nextLine();
		fun(str,1);
	}//end main()
	private static void fun(String str,int n) {
		boolean flag=true;
		while(flag) {
		for(int i=n;i<str.length()-1;i+=n) {
			if(!str.substring(0,n).equals(str.substring(i,i+n))) {
				flag=false;
			}else {
				continue;
			}
		}//end for
		break;
		}//end while
		if(flag==false) {
			if(n==1) {
				System.out.println(str.length());
			}
		}else {
			System.out.println(n);
		} 
			
	}//end fun()
}
