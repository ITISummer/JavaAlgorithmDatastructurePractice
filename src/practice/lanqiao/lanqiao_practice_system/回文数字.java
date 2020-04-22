package practice.lanqiao.lanqiao_practice_system;

import java.util.Scanner;

public class 回文数字 {
	private static int arr[]=new int[6];
	private static int i=0;//�±�
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int n=input.nextInt();
		for(int i=10000;i<=999999;i++) {
			if(isEquals(i,n)&&isPalindromicNum())
					System.out.println(i);
			else
					continue;
		}//end for
	}//end main()

	public static boolean isEquals(int temp,int n) {
		int sum=0;
		while((temp%10)>0) {
			sum+=temp%10;
			arr[i++]=temp%10;
			System.out.println(temp);
			temp/=10;
		}//end while
		return sum==n;
	}//end sum()

	public static boolean isPalindromicNum() {
		int mid=(i)/2-1;
		for(int j=0;j<=mid;j++) {
			if(arr[j]!=arr[i-j]) {
				i=0;
				System.out.println(i);
				return false;
			}//end if
		}//end for
		i=0;
		System.out.println(i);
		return true;
	}//end isPalindromicNum()
	
}
