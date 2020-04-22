package practice.lanqiao.lanqiao_practice_system;

import java.util.Arrays;
import java.util.Scanner;

public class 小朋友排队 {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int n=input.nextInt();
		int arr1[]=new int[n];
		int arr2[]=new int[n];
//		System.out.println(Arrays.toString(arr2));
		for(int i=0;i<arr1.length;i++)
			arr1[i]=input.nextInt();
		for(int i=0;i<arr1.length;i++)
			for(int j=0;j<arr1.length-i-1;j++)
				if(arr1[j]>arr1[j+1]) {
					arr1[j]=arr1[j]^arr1[j+1];
					arr1[j+1]=arr1[j]^arr1[j+1];
					arr1[j]=arr1[j]^arr1[j+1];
//					arr2[j]+=j+1;
//					arr2[j+1]+=j+1;
				}//end if
		System.out.println(Arrays.toString(arr1));
	}//end main()
}
