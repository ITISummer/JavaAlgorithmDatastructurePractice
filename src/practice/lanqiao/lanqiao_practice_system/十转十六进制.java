package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 十转十六进制 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String sum="";
		int n = input.nextInt();
		do {
			switch(n%16) {
			case 0:sum+="0";break;
			case 1:sum+="1";break;
			case 2:sum+="2";break;
			case 3:sum+="3";break;
			case 4:sum+="4";break;
			case 5:sum+="5";break;
			case 6:sum+="6";break;
			case 7:sum+="7";break;
			case 8:sum+="8";break;
			case 9:sum+="9";break;
			case 10:sum+="A";break;
			case 11:sum+="B";break;
			case 12:sum+="C";break;
			case 13:sum+="D";break;
			case 14:sum+="E";break;
			case 15:sum+="F";break;
			}//end swtich
			n/=16;
		}while(n!=0);
		StringBuffer reverseSum=new StringBuffer(sum);
		System.out.println(reverseSum.reverse());
	}	
}
